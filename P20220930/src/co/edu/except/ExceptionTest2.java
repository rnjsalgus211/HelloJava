package co.edu.except;
class NegativeValException extends RuntimeException { //예외 클래스 만들기
	NegativeValException() {
		
	}
	
	NegativeValException(String msg) {
		super(msg);
	}
}

//try-catch 구문에 예외 넣어주기
public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			positiveVal(10, -20);
		} catch (NegativeValException e) {
			System.out.println("예외가 발생.");
//			e.printStackTrace(); //에러 발생한 로그를 보여주는 실행문
		}
		System.out.println("프로그램 종료.");
	}
	
	public static int positiveVal(int n1, int n2) throws NegativeValException {
		int result = n1 + n2;
		if(result <0) {
			throw new NegativeValException("음의 값이 발생했습니다.");
		}
		return result;
		
		
	}
}
