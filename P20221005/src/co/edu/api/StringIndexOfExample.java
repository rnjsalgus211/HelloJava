package co.edu.api;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍"); //'프'로 시작하는 인덱스 번호를 출력
		System.out.println(location);
		
		if(subject.indexOf("자바") !=-1) { //특정 문자열이 포함되어있는지 여부를 확인하기 위해 자주 사용하는 실행코드 
			System.out.println("자바와 관련된 책이군요!"); //포함되어있는 경우
		}else {
			System.out.println("자바와 관련 없는 책이군요!");//포함되지 않은 경우
		}
	}
}
