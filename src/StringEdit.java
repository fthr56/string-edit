import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//일반적인 특수 문자들은 단어와 한 세트라고 생각하고 문장의 끝을 알리는 ( ? ! ; .)가 문장의 끝에 있을때만 다시 문장의 끝에 위치하게 만듬
//	   입력: Do you know Doctor who?		출력: who Doctor know you Do?
//	   입력: Do! you know Doctor who		출력: who Doctor know you Do!
//	   입력: Do you know Doctor, who. 		출력: who Doctor, know you Do.
public class StringEdit {
	public static void main(String[] args) {
		String inputText;
		Scanner scanner = new Scanner(System.in);

		System.out.println("문자열을 입력 하세요.");
		inputText = scanner.nextLine();
		String[] result = inputText.split(" ");

		reverse(result); // 역순으로 출력
		checkAlphabet(inputText); // 알파벳 빈도 확인 및 출력
		scanner.close();
	}

	public static void reverse(String[] result) {

		result = checkLastChar(result); // 마지막 문자 확인 후 처리하는 메소드
		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s ", result[i]);
		}
		System.out.println();
	}

	// 마지막 문자 확인 후 (? ! ; .)이면 역순이 된 다음에도 마지막 위치에 있게 조정
	// 메인 메소드에서 선언한 변수를 변경 함으로 private로 생성
	private static String[] checkLastChar(String[] result) {
		int lastword = result.length - 1; // string배열의 마지막 단어가 있는 인덱스
		int lastchar = result[lastword].length() - 1; // 마지막 단어의 마지막 문자의 인덱스

		// 마지막 문자가 (? ! ; .)인지 확인 확인.
		if ((result[lastword].charAt(lastchar) == '?') || (result[lastword].charAt(lastchar) == '!')
				|| (result[lastword].charAt(lastchar) == ';') || (result[lastword].charAt(lastchar) == '.')) {

			// 역순으로 가장 뒤에 오는 단어에 문장의 끝을 나타내는 특수 문자 삽입
			result[0] = result[0] + result[lastword].charAt(lastchar);
			// 기존에 가장 마지막 단어에 있던 특수 문자 삭제
			result[lastword] = result[lastword].substring(0, lastchar);
		}
		return result;
	}

	public static void checkAlphabet(String inputText) {

		// 알파벳의 빈도를 넣을 배열 (인덱스 0~25 == 'a' ~ 'z', 대소문자 구별 X)
		int[] alphabetArr = new int[26];
		int total = 0;

		// 총 알파벳 수 출력
		for (int i = 0; i < inputText.length(); i++) {
			char alphabet = inputText.charAt(i);
			// 아스키코드 값으로 알파벳 범위에 있는지 확인 후 alphabetArr 배열에 해당 알파벳배열 인덱스에 빈도 수 카운팅
			if (('a' <= alphabet && alphabet <= 'z') || ('A' <= alphabet && alphabet <= 'Z')) {
				if (alphabet <= 'Z') {
					alphabetArr[alphabet - 'A']++;
				} else {
					alphabetArr[alphabet - 'a']++;
				}
				total++; // 문장의 총 알파벳 수 세기
			}
		}
		System.out.printf("전체 알파벳 수: %d\n" , total);
		alphabetFrequency(alphabetArr, total);
	}
	
	public static void alphabetFrequency(int[] alphabetArr, int total) {
		// 해시맵을 추가하여 Key == 빈도수(Integer), Value == "a~z: x개 ...." (String) 형식으로
		// 사용
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < alphabetArr.length; i++) {
			int frequency = alphabetArr[i]; // alphabetArr[i]에 저장되어 있는 값은 a~z까지의 빈도수
			if (frequency > 0) {
				if (!map.containsKey(frequency)) { // 아직 사용되지 않은 키값이면 해당 키값의 value값인 String을 ""로 초기화 시킨다.
					map.put(frequency, "");
				}
				// 같은 빈도수(키값)의 알파벳들은 (value + "알파벳: 키값\n") 으로 문자열을 추가한다.
				String value = map.get(frequency) + (char) (i + 'a') + ": " + frequency + "개\n";
				map.put(frequency, value);
			}
		}
		// 하나의 알파벳으로만 이루어진 문장일 수 있으니, 최대 나올수 있는 빈도수 total(사용한 알파벳의 총 갯수)에서부터 1개까지 확인 한다.
		for (int frequency = total; frequency > 0; frequency--) {
			if (map.containsKey(frequency)){
				System.out.print(map.get(frequency));
			}
		}
	}
}
