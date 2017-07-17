import java.util.Scanner;

//특수 문자 처리는 주로 문장의 끝을 알리는 ( ? ! ; .)이 문장의 끝에 있을때만 다시 문장의 끝에 가게하고 문장의 사이에 나오면 단어를 따라가게 만듬
//	   입력: Do you know Doctor who?		출력: who Doctor know you Do?
//	   입력: Do! you know Doctor who		출력: who Doctor know you Do!
//	   입력: Do you know, Doctor who. 		출력: who Doctor know, you Do.
public class StringEdit {
	public static void main(String[] args) {
		String inputText;
		Scanner scanner = new Scanner(System.in);

		System.out.println("문자열을 입력 하세요.");
		inputText = scanner.nextLine();
		String[] result = inputText.split(" ");

		System.out.println("입력 문자열: " + inputText);

		reverse(result); // 역순으로 출력
		checkAlphabet(inputText); // 알파벳 빈도 확인 및 출력
		scanner.close();
	}

	public static void reverse(String[] result) {

		result = checkLastChar(result); // 마지막 문자 확인 후 처리하는 메소드
		System.out.print("출력 문자열: ");
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
		int count = 0;

		// 총 알파벳 수 출력
		for (int i = 0; i < inputText.length(); i++) {
			char alphabet = inputText.charAt(i);
			// 아스키코드 값으로 알파벳 범위에 있는지 확인 후 alphabetArr 배열에 해당 알파벳 인덱스에 빈도 수 카운팅
			if (('a' <= alphabet && alphabet <= 'z') || ('A' <= alphabet && alphabet <= 'Z')) {
				if (alphabet <= 'Z') {
					alphabetArr[alphabet - 'A']++;
				} else {
					alphabetArr[alphabet - 'a']++;
				}
				count++; // 총 알파벳 수 세기
			}
		}
		System.out.printf("전체 알파벳 수: %d\n" , count);

		//알파벳 빈도가 높은 순으로 출력
		alphabetFrequency(count, alphabetArr);
	}
	
	public static void alphabetFrequency(int count, int[] alphabetArr){
		// 한개의 알파벳만으로 된 문장일 수 있으며, 내림차순으로 출력되게 최대 빈도(count) 부터 1 까지 alphabetArr
		// 배열에서 빈도를 확인하여 출력시킴
		for (int i = count; i > 0; i--) {
			for (int j = 0; j < alphabetArr.length; j++) {
				if (i == alphabetArr[j]) {
					System.out.printf("%c: %d개\n", (j + 'a'), i);
				}
			}
		}	
	}
	
}
