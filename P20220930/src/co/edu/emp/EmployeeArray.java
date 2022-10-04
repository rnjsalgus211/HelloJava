package co.edu.emp;

import java.util.Scanner;

//배열을 활용해서 정보를 저장 (구현클래스)
public class EmployeeArray implements EmployeeService {
	//데이터 저장 공간생성
	Employee[] list;
	int idx; //필드값, 따로 선언 안하면 0이 초기값
	Scanner scn = new Scanner(System.in);
	
	@Override
	public void init() {
		System.out.println("사원수를 입력>> ");
		int cnt = Integer.parseInt(scn.nextLine()); //배열의 크기 정하는 작업
		list = new Employee[cnt]; //list는 employees를 'cnt'명 입력 받을수 있도록 하겠다.
	}

	@Override
	public void input() {
		
		if(idx >= list.length) {
			System.out.println("더이상 입력할 수 없습니다.");
			return; //메소드 안에서 return을 만나면 프로그램 진행이 종료됨
			
		}
		
		System.out.println("사번>> ");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>> ");
		String name = scn.nextLine();
		System.out.println("부서>> ");
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("급여>> ");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>> ");
		String email = scn.nextLine();
		
		
		Employee emp = new Employee(eId, name, sal, deptId, email); //인스턴스 하나 생성 >> list라는 배열변수에 담을것
		list[idx++] = emp; //list라는 배열에 idx(필드)	
		
	}
	@Override
	public String search(int employeeId) {
		return null;
	}
	@Override
	public void print() {

	}

}
