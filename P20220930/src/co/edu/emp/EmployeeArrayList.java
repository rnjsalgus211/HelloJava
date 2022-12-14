package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션(ArrayList)을 활용해서 데이터를 저장하는 기능을 가지고있다.
public class EmployeeArrayList implements EmployeeService {
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
		System.out.println("사원을 등록합니다.");

		System.out.print("사번>>  ");
		int eId = -1;
		while (true) {
			try {
				eId = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("사원번호를 확인하세요.");
				System.out.print("사번>>  ");
			}
		}
		System.out.print("이름>>  ");
		String name = scn.nextLine();

		System.out.print("급여>>  ");
		int sal = -1;
		while (true) {
			try {
				sal = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("급여를 확인하세요.");
				System.out.print("급여>>  ");
			}
		}

		System.out.print("부서번호>>  ");
		int deptId = -1;
		while (true) {
			try {
				deptId = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("부서번호를 확인하세요.");
				System.out.println("부서번호>>");
			}
		}
		System.out.print("이메일>>  ");
		String email = scn.nextLine();
		System.out.println("사원 등록이 완료되었습니다.");

		Employee empList = new Employee(eId, name, sal, deptId, email);

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

}
