package co.edu.emp.list;

import java.util.ArrayList;

import co.edu.emp.Employee;

public class ListApp {
	public static void main(String[] args) {
		//배열의 단점 - 크기가 한번 정해지면 확장이 X, null값이 존재하기때문에 넓값 제외하는 실행문 만들어야돼서 귀찮 이때까지는 배열로 공간을 만들어주었음.
		//배열 -> 컬렉션(ArrayList, HashSet->집합처럼 중복된값은 받지않고 값을 담아놓을수있는 컬렉션, HashMap)
		String[] strAry = new String[10]; 
//		ArrayList list = new ArrayList(); //클래스 ,import 필요 ctrl + shift+ O 
		ArrayList<String> list = new ArrayList<String>(); //문자열 타입만 담겠습니다.(설정해주면 캐스팅 해줄 필요 없어서 에러 줄일수있음.)
//		어떤 형태의 인스턴스 담을지 선언 할 수 O, 따로 선언하지않으면 모든 형태의 인스턴스를 담을 수 있도록 Object 타입으로 설정 되어짐
		//Object클래스로 설정하면 모든 클래스는 Object 클래스의 자식이기때문에 모든 값을 넣을 수 있음.
		list.add("hello"); //컬렉션에 인덱스 추가할때는 컬렉션명.add(어쩌고)
		list.add("new Employee"); 
		
		for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i)); //인덱스 값으로 데이터를 불러와야함
//		System.out.println(list.get(1));
		}
		
		
		ArrayList<Integer> intList = new ArrayList<Integer>(); //정수 타입만 담겠습니다.
		intList.add(100);
//		intList.add("100"); //데이터 타입 맞지않음
		
		//employee 클래스에 만들어뒀던 정보를 이용해서
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(100, "홍길동", 1000));
		empList.add(new Employee(200, "김민수", 2000));
		empList.add(new Employee(300, "오해원", 3000));
		empList.add(new Employee(400, "차은우", 4000));
//		empList.add(100); 데이터 타입 맞지않음
		
		String result = null;
		int salary = 0;
		for(int i=0; i<empList.size(); i++) {
			//empList안 0, 1, 2,3번 인덱스의 EmployeeId가 200번이면 
			if(empList.get(i).getEmployeeId()==200) {
				result = empList.get(i).getName();
				salary = empList.get(i).getSalary();
			}
		}
		System.out.println("이름은 " + result + ", 급여는 " + salary + "만원입니다.");
		
	}
}//end of class














