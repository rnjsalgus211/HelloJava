package co.edu.emp;

class InvalidDeptException extends NumberFormatException { //예외 클래스 만들기
	InvalidDeptException() { //매개값이 없는 생성자	
	}
	
	
	InvalidDeptException(String msg) { //매개값 하나
		super(msg);
	}
}
