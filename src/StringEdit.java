
public class StringEdit {
	public static void main(String[] args) {
		String inputText;

		inputText = "Do you know Doctor who?";
		String[] result = inputText.split(" ");
		int[] alphabetArr = new int[26];

		System.out.println("입력 문자열: " + inputText);
		int last1 = result.length - 1;
		int last = result[last1].length() - 1;

		if ((result[last1].charAt(last) == '?') || (result[last1].charAt(last) == '!')
				|| (result[last1].charAt(last) == ';') || (result[last1].charAt(last) == '.')) {
			result[0] = result[0] + result[last1].charAt(last);
			result[last1] = result[last1].substring(0, last);
		}
		System.out.print("출력 문자열: ");

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s ", result[i]);
		}
		System.out.println();
		
		int count = 0;
		for (int i = 0; i < inputText.length(); i++) {
			char alphabet = inputText.charAt(i);
			if (('a' <= alphabet && alphabet <= 'z') || ('A' <= alphabet && alphabet <= 'Z')) {
				if (alphabet <= 'Z') {
					alphabetArr[alphabet - 'A']++;
				} else {
					alphabetArr[alphabet - 'a']++;
				}
				count++;
			}
		}
		System.out.println("전체 수: " + count);

		for (int i = 0; i < alphabetArr.length; i++) {
			if (alphabetArr[i] > 0) {
				System.out.println((char) (i + 65) + ": " + alphabetArr[i]);
			}
		}
	}
}
