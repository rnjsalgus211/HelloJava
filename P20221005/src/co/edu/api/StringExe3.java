package co.edu.api;

import java.util.ArrayList;
import java.util.List;

//내용을 담기위한 클래스
class Box<T>{ //<T>의 의미 : 박스 클래스를 ''사용하는 시점''에 타입을 정하겠다. 
	T obj; //Object obj 대신 T obj; 
	void set(T obj) { // Object obj 대신 T obj;
		this.obj = obj;
	}
	T get() { // Object obj 대신 T obj;
		return obj; //리턴해주는 타입이 obj라는 필드.
	}
}

class Member {
	private String name;
	private String id;
	private int point;
	
	
	public Member(String name, String id, int point) {
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}

class Employee{
	private String empName;
	private String empId;
	private int salary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}


public class StringExe3 {
	public static void main(String[] args) {
		
		Box<String> box = new Box<String>(); //스트링을 넣을수있는 박스로 제한 -> 정수타입에서는 에러를 띄워줌. 정하지않으면 빨간줄안뜨는 에러 발생
		box.set("Hello"); //박스에는 문자열, 정수 담을수 있음
//		box.set(200); //Error 정수타입으로 담겨진 200을 산출하려면 Integer result = (Integer)box.get();으로 수정해서 출력
		String result = box.get(); //문자열 타입이면 항상 캐스팅 작업 (String)box.get(); //박스 타입을 정해주었을 때는 캐스팅할 필요 X
		System.out.println(result); //문법상으로는 문제가 없는데 실행하면 오류뜸 -> 
		
		String[] stAry;
		List<String> list = new ArrayList<String>(); //컬렉션 사용할때는 임폴트 해줘야함
		list.add("hello");
		//list.add(200; Error
		
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동", "hong",10000));
		members.add(new Member("김민기", "kim",20000));
		members.add(new Member("박인기", "park",30000));
		
		List<Employee> employees = changeType(members); //Member => Employee
		for(Employee emp : employees) {
			System.out.println("name: "+ emp.getEmpName() + ", id:" +emp.getEmpId());
		}
	}
	
	public static List<Employee> changeType(List<Member> collect) {
		//List<Member>값을 List<Employye>에 담아보자
		// 3 -> 3
		// coding.
		//매개값으로 들어온 List<Member>컬렉션을 반복해서 돌겠습니다.
		List<Employee> empls = new ArrayList<Employee>();
		for(Member member : collect) {
			Employee emp = new Employee();
			emp.setEmpId(member.getId());
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());
			empls.add(emp); //오버라이딩 안해놨기때문에 지금은 주소값으로 출력
		}
		return empls;
		
		
		
		
	}
}
