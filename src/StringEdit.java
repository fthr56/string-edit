
public class StringEdit {
	public static void main(String[] args) {
		String inputText;

		inputText = "Do you know Doctor who?";
		String[] result = inputText.split(" ");

		System.out.println("입력 문자열: " + inputText);
		reverse(result);
		checkAlphabet(inputText);
		
	}
	//TODO: 메소드들을 좀더 분리 할것 & 변수 이름 손볼것
	public static void reverse(String[] result){
		///////////////////////
		//입력 받은 문자열을 역순으로 출력 & 마지막 단어에 있는 문장의 끝을 의마하는 '?','!',';','.' 특수 문자만 역순에서도 마지막 단어에 따라오게 만든다.
		int last1 = result.length - 1;
		int last = result[last1].length() - 1;
		if ((result[last1].charAt(last) == '?') || (result[last1].charAt(last) == '!')
				|| (result[last1].charAt(last) == ';') || (result[last1].charAt(last) == '.')) {
			result[0] = result[0] + result[last1].charAt(last);						//역순으로 가장 뒤에 올 단어의 마지막에 특수문자 삽입
			result[last1] = result[last1].substring(0, last);						//기존에 가장 마지막에 있던 특수 문자 삭제
		}
		System.out.print("출력 문자열: ");

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s ", result[i]);
		}
		////////////////////////////출력
		System.out.println();	
	}
	
	public static void checkAlphabet(String inputText){
		////////알파벳 수 세기
		int[] alphabetArr = new int[26];
		int count = 0;
		//총 알파벳 수 출력
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

		//알파벳 빈도 체크
		//TODO: 빈도가 높을 수록 먼저 나오게 만들기
		for (int i = 0; i < alphabetArr.length; i++) {
			if (alphabetArr[i] > 0) {
				System.out.println((char) (i + 65) + ": " + alphabetArr[i]);
			}
		}
		//////////////////////////
	}
}
