import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringEditNoComment {
	public static void main(String[] args) {
		String inputText;
		Scanner scanner = new Scanner(System.in);

		System.out.println("문자열을 입력 하세요.");
		inputText = scanner.nextLine();
		String[] result = inputText.split(" ");

		reverse(result); 
		checkAlphabet(inputText); 
		scanner.close();
	}

	public static void reverse(String[] result) {

		result = checkLastChar(result); 
		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s ", result[i]);
		}
		System.out.println();
	}

	private static String[] checkLastChar(String[] result) {
		int lastword = result.length - 1;
		int lastchar = result[lastword].length() - 1; 

		if ((result[lastword].charAt(lastchar) == '?') || (result[lastword].charAt(lastchar) == '!')
				|| (result[lastword].charAt(lastchar) == ';') || (result[lastword].charAt(lastchar) == '.')) {

			result[0] = result[0] + result[lastword].charAt(lastchar);
			result[lastword] = result[lastword].substring(0, lastchar);
		}
		return result;
	}

	public static void checkAlphabet(String inputText) {

		int[] alphabetArr = new int[26];
		int total = 0;

		for (int i = 0; i < inputText.length(); i++) {
			char alphabet = inputText.charAt(i);
			if (('a' <= alphabet && alphabet <= 'z') || ('A' <= alphabet && alphabet <= 'Z')) {
				if (alphabet <= 'Z') {
					alphabetArr[alphabet - 'A']++;
				} else {
					alphabetArr[alphabet - 'a']++;
				}
				total++;
			}
		}
		System.out.printf("전체 알파벳 수: %d\n" , total);
		alphabetFrequency(alphabetArr, total);
	}
	
	public static void alphabetFrequency(int[] alphabetArr, int total) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < alphabetArr.length; i++) {
			int frequency = alphabetArr[i]; 
			if (frequency > 0) {
				if (!map.containsKey(frequency)) { 
					map.put(frequency, "");
				}
				String value = map.get(frequency) + (char) (i + 'a') + ": " + frequency + "개\n";
				map.put(frequency, value);
			}
		}
		for (int frequency = total; frequency > 0; frequency--) {
			if (map.containsKey(frequency)){
				System.out.print(map.get(frequency));
			}
		}
	}
}
