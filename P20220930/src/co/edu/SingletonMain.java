package co.edu;

public class SingletonMain {
	public static void main(String[] args) {
		// 1) Student 인스턴스 생성할 때 마다 다른 주소값에 생성됨
		Student s1 = new Student();
		Student s2 = new Student();
		
		// 2) Singleton (new생성자는 private 상태이기때문에 호출할수 X)
		// 인스턴스가 클래스에 할당되어있어서 동일한 인스턴스가 만들어짐 sg1에 만들어진 인스턴스를 sg2가 그대로 가지고있음
		// 메모리 사용량을 줄이겠습니다 -> singleton
		Singleton sg1 = Singleton.getInstance();
		Singleton sg2 = Singleton.getInstance();
		System.out.println(s1 ==s2);
		System.out.println(sg1 == sg2);
	}
}
