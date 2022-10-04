package co.edu.inherit;

public class Child2 extends Parent { //부모 클래스 상속 받지 않음 (여러개 상속 받을 수 없음, 자바는 부모클래스 1개만 상속받을수있다)
	String field2;
	Child2() {
		System.out.println("Child2() call");//생성자 호출했습니다
	}
	void method2() {
		System.out.println("method2() call.");
	}
	
}
