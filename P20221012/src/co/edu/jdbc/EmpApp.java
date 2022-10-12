package co.edu.jdbc;

import java.util.List;

//메인 메소드를 담고있는 클래스(실행 클래스)
public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		 //list컬렉션
		
		int empId = 500;
		String lastName = "Hong";
		String email = "hongkil@email";
		String jobId = "ST_MAN";
		String hireDate = "2021-05-11";
		Employee emp1 = new Employee(empId, lastName, email,  hireDate, jobId);
		
//		empDao.insert(emp1);
//		empDao.update(emp1); 
//		empDao.delete(empId);
		System.out.println(empDao.getEmp(empId));
		
		//조회.
//		List<Employee> employees = empDao.search();
		
//		for(Employee emp : employees) { //가지고있는 emp를 한번씩 출력
//			System.out.println(emp);
//		}
	}
}
