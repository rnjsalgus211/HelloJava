package co.edu;

// 사람: 속성(이름, 나이, 키, 몸무게)
//	   기능(달린다, 먹는다, 잠을잔다)
public class Person { //클래스를 통해서 오브젝트를 정의
	//속성 =>(클래스 내에서는) 필드 라고 부름. 설계도라고 보면 됨. (설계도를 타고 다닐 수 없는 것 처럼 자동차라는 인스턴스를 만들어줘야함)
	String name;
	int age;
	double height;
	double weight;
	//기능 => 메소드.
	void run() { //메소드 이름, 매개값
		System.out.println(name + " 달립니다."); //여기서의 name은 String name(필드)를 의미함		
	}
	void eat(String food) {
		System.out.println(name +"가 " +food + "을 먹습니다.");
	}
	void sleep() {
		System.out.println(name + " 잠을 잡니다.");
	}
}//이런식으로 정의 한 값들은 클래스 내에서 사용하는 것 X


