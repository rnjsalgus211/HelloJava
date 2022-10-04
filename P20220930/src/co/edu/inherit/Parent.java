package co.edu.inherit;

public class Parent extends Object{ //모든 클래스는 (최상위 클래스)Object를 상속받고 있다. (따로 설정해주지 않았을때)
	
	String fieldString;
	

	Parent(){ //기본 생성자 필수
	System.out.println("Parent() call.");
	}
	Parent(String args)  { //매개변수를 받는 생성자 Parent()
		System.out.println("Paretn(String args) call."); //부모 클래스에 기본생성자를 호출 하였습니다
	}
	void method() {
		System.out.println("parent method() call.");
	}
	
	@Override
	public String toString() {
		return "Parent [fieldString=" + fieldString + "]";
	}
}
