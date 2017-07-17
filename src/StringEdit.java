
public class StringEdit {
	public static void main(String[] args) {
		String inputText;

		inputText = "Do you know Doctor who?";
		String[] result = inputText.split(" ");

		System.out.println("입력 문자열: " + inputText);
		reverse(result);
		checkAlphabet(inputText);

	}

	// TODO: 메소드들을 좀더 분리 할것 & 변수 이름 손볼것
	public static void reverse(String[] result) {
		///////////////////////
		// 입력 받은 문자열을 역순으로 출력 & 마지막 단어에 있는 문장의 끝을 의마하는 '?','!',';','.' 특수 문자만
		/////////////////////// 역순에서도 마지막 단어에 따라오게 만든다.
		int last = result.length - 1; // string배열의 마지막 단어가 있는 인덱스
		int lastchar = result[last].length() - 1; // 마지막 단어의 마지막 문자의 인덱스
		if ((result[last].charAt(lastchar) == '?') || (result[last].charAt(lastchar) == '!')
				|| (result[last].charAt(lastchar) == ';') || (result[last].charAt(lastchar) == '.')) {
			
			// 역순으로 가장 뒤에 오는 단어의 마지막 특수 문자 삽입
			result[0] = result[0] + result[last].charAt(lastchar); 
			// 기존에 가장 마지막에 있던 특수 문자 삭제
			result[last] = result[last].substring(0, lastchar); 
		}
		System.out.print("출력 문자열: ");
		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s ", result[i]);
		}
		//////////////////////////// 출력
		System.out.println();
	}

	public static void checkAlphabet(String inputText) {
		//////// 알파벳 수 세기
		int[] alphabetArr = new int[26];
		int count = 0;
		// 총 알파벳 수 출력
		for (int i = 0; i < inputText.length(); i++) {
			char alphabet = inputText.charAt(i);
			
			// 아스키코드 값으로 알파벳 범위에 있는지 확인
			if (('a' <= alphabet && alphabet <= 'z') || ('A' <= alphabet && alphabet <= 'Z')) { 
				
				// 0~26배열을 이용하여 a~z 알파벳 각각 몇개가 있는지 카운팅(대소문자 구분 X)
				if (alphabet <= 'Z') {
					alphabetArr[alphabet - 'A']++; 
				} else {
					alphabetArr[alphabet - 'a']++;
				}
				count++; // 알파벳이 총 몇개 있는지 세기
			}
		}
		System.out.println("전체 수: " + count);

		//TODO: 2중 for문을 손댈순 없을까?
		for (int i = count; i > 0; i--) {
			for (int j = 0; j < alphabetArr.length; j++) {
				if (i == alphabetArr[j]) {
					System.out.printf("%c: %d개\n", (j + 'a'), i);
				}
			}
		}
	}
}
