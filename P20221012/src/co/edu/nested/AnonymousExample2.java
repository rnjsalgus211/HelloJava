package co.edu.nested;

interface Run{
	void run();
}
class Runner implements Run {
	@Override
	public void run() {
		System.out.println("달립니다.");
	}
}

public class AnonymousExample2 {
	public static void main(String[] args) {
		
		//익명 구현 객체 : 상황에 따라 기능이 다를경우.
		Run runner = new Run() { 
			//필드 선언 가능.
			String kind;
			void runKind() {
				System.out.println("육상");
			}
			
			@Override
			public void run() {
				System.out.println("구현 run.");
				runKind();
			}
		};
		runner.run();
		
		Run runner2 = new Run() {
			@Override
			public void run() {
				System.out.println("구기종목");
				
			}
		}; 
		runner2.run();
	}

}
