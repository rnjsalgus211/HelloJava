package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션(ArrayList)을 활용해서 데이터를 저장하는 기능을 가지고있다.
public class EmployeeArrayList2Answer implements EmployeeService {
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료");
	}

	@Override
	public void input() {
		//사번 입력 & 예외처리
		System.out.println("사원을 등록합니다.");
		int eId = readInt("사번>>  ");
		System.out.print("이름>>  ");
		String name = scn.nextLine();
		

		int deptId = -1;
		while(true) {
			deptId = readInt("부서>>  ");
			try {
				validDept(deptId);
				break;
			}catch(InvalidDeptException e1) {
				System.out.println(e1.getMessage());
			}
		}
		//급여 & 예외처리
		int sal = readInt("급여>>  ");
		System.out.println("사원 등록이 완료되었습니다.");

		Employee empList = new Employee(eId, name, sal, deptId);

		list.add(empList);
	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for(int i=0; i<list.size(); i++) {
//			//Employee emp = list.get(i);
//			if(emp.getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				//result = empList.getName();
//				break;
//			}
//		}
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		System.out.printf("%5s %10s %7s\n", "사원번호", "이름  ", "급여  ");
		System.out.println("================================");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(),
					list.get(i).getSalary());
		}
	}

	@Override
	public int searchSal(int employeeId) {
		int sal = -1;
//		for(int i=0; i<list.size(); i++) {
//			Employee emp = list.get(i);
//			if(emp.getEmployeeId() == employeeId) {
//				sal = emp.getSalary();
//				break;
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				sal = emp.getSalary();
				break;
			}
		}
		return sal;
	}
		
	public void validDept(int dept) throws InvalidDeptException{
		int validDept = dept %10;
		if (validDept !=0 || dept>30) {
			throw new InvalidDeptException("잘못된 부서정보입니다.");
		}
		
	}
	
	
	//예외처리가 반복되면 메소드로 묶어서 사용하자......................
	public int readInt(String msg) {
		int result = -1;
		while(true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		return result;
	}
	
	
	

}
