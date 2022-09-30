package co.edu;

public class Singleton {
	//private 정적 필드
	private static Singleton singleton = new Singleton(); //Singleton 생성자를 호출하겠다
	
	//private 생성자
	private Singleton() {
		
	}
	
	//위에서 만든 필드 값 singleton을 리턴 -> 생성자를 만들 수 있다.
	public static Singleton getInstance() {
		return singleton;
		
	}
	
	
}
