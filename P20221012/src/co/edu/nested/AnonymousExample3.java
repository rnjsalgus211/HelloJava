package co.edu.nested;

//익명구현객체인데 특별한 케이스....
//추상메소드가 하나만 존재하는 인터페이스 => Functional 인터페이스 라고 지칭함.
interface MyInterface {
	void run(); //매개값이 없고 반환값도 없을 때. 1.람다식 가능
}

interface MyInterface2 {
	void run(String kind); //매개값 하나인 경우 2.람다식
}

interface MyInterface3 { //매개값 2개
	int sum(int num1, int num2);
}

public class AnonymousExample3 {
	public static void main(String[] args) {
		 //new MyInterface() << 없어도됨.
		 //()매개값을 받아서 -> {}안에걸 구현하고 싶습니다.(
		 //구현하는 부분이 하나의 실행문이면 {}도 삭제가능. (두개 이상이면 꼭 넣어줘야함)
		 // 인터페이스는 원래 객체로 만들수없는 건데 익명객체를 이용해서 만들어보겠다.
		 //람다표현식. 1번
		MyInterface intf = ()-> System.out.println("MyInterface Run!");
		intf.run();
		
		//익명구현객체 run을 반드시 구현해야합니다.
		//매개변수가 하나면 (String kind)로 써줄 필요없이 kind만 써줘도됨.
		//매개변수 하나일 경우 매개변수를 감싸고있는 () 삭제가능.
		//람다식 2번.
		MyInterface2 intf2 =  kind -> System.out.println(kind + " Run.");
		intf2.run("농구종목");
		
		
		//람다식3번
		//실행구문 1개, {} 삭제가능
		//변수가 int로 하나뿐 -> 삭제가능.
		//반환되는 값이 return구문 뒤에있을 때 return도 삭제가능.
		MyInterface3 intf3 = (num1, num2)-> num1*2 + num2;
		int result = intf3.sum(10, 20); //반환되는값이 있습니다. 라는 의미
		
		//또 다른 기능을 가지고있는 익명객체를 만들고싶다.
		intf3 = (num1, num2) -> num1*2 + num2*3;
		result = intf3.sum(11, 22);
	}
}
