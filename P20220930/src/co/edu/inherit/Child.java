package co.edu.inherit;

public class Child extends Parent{ //부모 클래스를 상속받는 경우
	String field1;
	Child() {
		super("args"); //부모 클래스의 생성자를 호출하겠습니다.
		System.out.println("Child() call.");	
	}
	void method1() {
		System.out.println("method1() call.");
	}
	
	//부모 클래스의 메소드를 재정의. overriding.
	@Override // 어노테이션: 부모클래스의 메소드를 자식 클래스에서 재정의 하겠다.(반환값, 메소드이름, 매개값을 체크)
	void method() { // 부모 클래스에 이미 정의 되어있는 메소드
		System.out.println("Child method() call."); 
		
		
	}
	@Override
	public String toString() {
		return "Child [field1=" + field1 + "]";
	}
	
}
