package co.edu.nested;
class Person {
	
	//클래스의 멤버 : 필드, 생성자, 메소드
	//필드
	String name;
	int age;
	//생성자
	Person(){}
	//메소드
	void showInfo() {
		//메소드 안에 선언된 클래스 : 로컬클래스
		class Local{
			void show() {
				System.out.println("show");
				
			}
		}
		Local local = new Local(); // -->>???? 무슨말
		local.show();
	}

	//중첩클래스, 내부클래스(Inner클래스)
	class Car {
		String carName;
		
		void run() { //Car 클래스 안의 run메소드
			System.out.println("run.");
		}
	}
	
	//Inner 클래스(정적)
	static class Calculator {
		void add() {
			System.out.println("add");
		}
	}
	
	class Run implements Runnable{ // ->>ui화면 만들때 사용해보겠음.
		@Override //run이라는 추상 메소드를 반드시 구현해주어야함.??
		public void run() {
		System.out.println("run 구현.");
			
		}
	}
	
	//Inner 인터페이스.
	interface Runnable{
		void run();
		
	}
	
}
public class NestedExample {
	public static void main(String[] args) {
		Person p = new Person();
		
		//인스턴스 멤버 클래스.
		Person.Car car = p.new Car(); //내부클래스 인스턴스.
		car.run(); //car클래스 안의 run메소드 호출.
		
		//정적 멤버 클래스.
		Person.Calculator cal = new Person.Calculator();
		cal.add(); //정적 멤버 클래스이기 때문에 클래스이름.내부클래스이름(Person.Calculator()) 으로 호출
		
		p.showInfo();//로컬 클래스를 호출.(메소드호출하면 클래스 호출됨)
		
		
		
		
	}
		
}
