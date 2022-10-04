package co.edu.inherit;

public class MainApp {
	public static void main(String[] args) {
		Child child = new Child(); //field1, method1()이 있음
		child.method();//Parent라는 클래스가 가지고 있었던 메소드
		child.method1();// Child의 메소드  
		//-------------------부모 클래스 및 메소드, 자식 클래스 및 메소드 호출 가능
		
		Child2 child2 = new Child2();
		child2.method(); // child2는 부모 클래스의 메소드 사용할 수 없음 -> Child2 파일에 extends 추가해줄 경우 상속받아 사용가능
		child2.method2(); //child2의 메소드(자기가 가지고있는 메소드)
		
		Parent c1 = new Parent();// 왼-오 타입 항상 같아야함
		c1 = new Child(); //부모 클래스의 변수에 자식 인스턴스 대입 가능.
		c1 = new Child2(); // 자동 형변환(자식인스턴스 -> 부모 인스턴스)
		
//		c1.method2(); // 부모가 가지고 있는 멤버들만 호출 가능하기 때문에 오류 발생
		
		if(c1 instanceof Child2) { //instanceof c1이라는 참조변수가 child2의 클래스의 인스턴스 이면
			Child2 c2 = (Child2) c1; //강제 형변환(casting)가능 
			c2.method2();
		}
		Parent c3 = new Parent(); // parent의 인스턴스 담겨져있음
		if (c3 instanceof Child2) { //인스턴스 맞는지 확인하고 코드를 넣어주면 활용할 수 있는 부분만 호출가능
		Child2 c4 = (Child2) c3; //캐스팅, 
		c4.method2(); //구문상으로는 오류x c3는 parent의 인스턴스 /-> c3를 차일드 클래스의 인스턴스로 강제형변환
		//
		}
	}
}
