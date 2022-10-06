package co.edu.api;

public class StringCharAtExample {
	public static void main(String[] args) {
		
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3);
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7); //ssn의 7번 인덱스 위치의 문자를 의미. (주민번호 뒷자리 첫번째 숫자)
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			 break;
		}
	}
}
