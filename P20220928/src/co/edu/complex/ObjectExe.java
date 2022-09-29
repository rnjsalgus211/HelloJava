package co.edu.complex;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {

		String s1 = "홍길동";
		int i1 = 20;
		double d1 = 162.3; // 162.0 (promotion >>자동 형 변환이 일어남)

		Person p1 = new Person();
		p1.name = "김민기";
		p1.age = 22;
		p1.height = 168.3;
		System.out.println(p1);

		Person p2 = new Person();
		p2.name = "권미현";
		p2.age = 28;
		p2.height = 160;

//		Person p3 = new Person();  // p1과 동일 한 값을 넣어주었을 때 
//		p3.name = "김민기";
//		p3.age = 22;
//		p3.height = 168.3;
//		System.out.println(p3);
//		
//		System.out.println(p1 ==p3 ); //p1과 p3가 같은가? ---> false! 서로 다른 주소에 생성되었기 때문에

		Person p3 = new Person();
		p3.name = "주소영";
		p3.age = 25;
		p3.height = 165.7;
		System.out.println(p3);

		System.out.println("이름:" + p1.name);
		System.out.println("나이:" + p1.age);
		System.out.println("키 :" + p1.height);
		Person[] persons = { p1, p2, p3 };
		System.out.println(persons[1].name);
		System.out.println(persons[1].age);
		System.out.println(persons[1].height);

//		persons[2].name = "송지은";// 인덱스 2번의 이름 값을 송지은으로 변경
//		p3.name = "송지은";

		// p1변수값과 persons[0]의 값을 비교.
		System.out.println(persons[0] == p1);

		for (int i = 0; i < persons.length; i++) {
			System.out.println(i + 1 + "번째 이름:" + persons[i].name + ", 나이: " + persons[i].age);
		}
		// 내가 찾는 이름에 해당하는 정보의 나이를 변경하는 코드
		Scanner scn = new Scanner(System.in);
		System.out.println("변경할 이름>>> ");
		String name = scn.nextLine();
		System.out.println("변경할 나이>>> ");
		int age = scn.nextInt();

		for (int i = 0; i < persons.length; i++) {
			if (persons[i].name.equals(name)) {
				persons[i].age = age;
				System.out.println(name + "의 변경된 나이는" + age);
			}
		}
		// 이름 찾아서 나이 변경
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].name == "권미현") {
				persons[i].age = 22;
				System.out.println(persons[i].name + persons[i].age);
			}
		}
		// 앞으로 문자열 비교할때는 .equals 사용하는것을 추천. (==비교연산자는 될수도있고 안될수도있어서..) 문자열.equals(비교문자열)
//		String n1 = new String("홍길동"); //n1과 n2는 각각의 주소값을 가지고있음(다른값) 
//		String n2 = new String("홍길동");
//		String m1 = "홍길동";
//		String m2 = "홍길동";
//		System.out.print("1.");
//		System.out.println(n1 == n2); // >>>false값 산출 (주소 값끼리 비교하는 식)
//		System.out.print("2.");
//		System.out.println(m1 == m2); // >>> true라고 뜸. 그냥 변수로 설정하면 주소값이 같게 설정됨
//		
//		String kwon = "권미현"; //코드 안에 직접(고정된) 값을 넣는것은 리터럴 ( << 문자열 리터럴 )
//		System.out.print("3.");
//		System.out.println(persons[1].name == kwon); // true 라고 뜸

	}

}
