package co.edu.api;

import java.util.HashSet;
import java.util.Set;

class Student {
	String name;
	int age;

	
	@Override
	public String toString() {
		return "학생의 이름은 " + name + ", 나이는 " + age + "입니다.";
	}
	
	//set 컬렉션: 동일한 인스턴스는 담아주지않는 컬렉션 (동일하다?-> equals, 해시코드값이 같은경우)
	//
	@Override
	public int hashCode() { //hashCode는 객체가 가지고있는 유니크한 값을 16진수로 반환해주는 메소드 (ex.주소값)
//		return super.hashCode(); //부모 클래스가 가지고있는 해시코드 값을 반환하겠습니다.
		return age;
	}
	
	
	@Override // 부모클래스의 메소드를 자식들이 재정의하겠다. (기능을)
	public boolean equals(Object obj) { // Object로 타입을 정의. Object를 상속받는 클래스들은 모든 값을 매개값으로 넣어줄수있음.
		if (!(obj instanceof Student)) {// obj가 Student클래스의 인스턴스가 아니면?
			return false;
		}
		Student str = (Student) obj; //
//		return super.equals(obj); //super는 부모클래스
		if (this.age == str.age && this.name.equals(str.name))
			return true;

		return false;
	}
}

//모든 클래스의 최상위 Object
public class ObjectExe {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();

		System.out.println(obj.equals(obj2)); // obj == obj2

		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 20;
		String s3 = "Hong";
//		System.out.println(s1.equals(s3)); // s3은 Stirng타입 -> 비교시 에러
		System.out.println(s1.toString()); // student 클래스에 따로 정의하지 X
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//Set 컬렉션: 인터페이스->구현클래스를 통해서 인스턴스 생성가능 //  ArrayList처럼 여러개의 데이터를 담기위한 컬렉션 
		Set<Integer> set = new HashSet<Integer>(); //Set set = new Set(); 사용할수없음.
		set.add(new Integer(100)); //취소선 -> 앞으로 쓰지마셈
		set.add(new Integer(110));
		set.add(new Integer(100));
		
		System.out.println("컬렉션의 크기: " + set.size()); // 컬렉션 크기 보여줘~ Set컬렉션: 중복된 값을 받지 않기때문에 크기 출력하였을 때 2로 나옴 100과 100은 중복.
		
		
		
		//Set 컬렉션에 Student 인스턴스 저장시 논리적으로 동일한 인스턴스로 판단 
		//hashCode(), equals() =>기준.
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		System.out.println("컬렉션의 크기: " + students.size());  
		
		
		
		
	}
}
