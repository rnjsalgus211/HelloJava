package co.edu.api;

public class StringLengthExample { //문자열 길이 리턴, 공백 포함
	public static void main(String[] args) {
		String ssn = "7306241230123";
		int length = ssn.length();
		if(length ==13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}
}
