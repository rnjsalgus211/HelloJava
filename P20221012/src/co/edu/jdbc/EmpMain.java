package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴=> 1.사원등록(insert) 2.한건조회(getEmp) 3.수정(update) 4.삭제(delete) 5.목록조회(search) 6.일괄등록
		// 9.종료

		while (true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
			System.out.println("입력>>  ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("사원번호를 입력하세요.");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("사원이름을 입력하세요.");
				String lastName = scn.nextLine();
				System.out.println("이메일을 입력하세요.");
				String email = scn.nextLine();
				System.out.println("입사일자를 입력하세요.");
				String hireDate = scn.nextLine();
				System.out.println("직무를 입력하세요.");
				String jobId = scn.nextLine();

				Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
				dao.insert(emp1);

			} else if (menu == 2) {
				System.out.println("조회 할 사원번호를 입력하세요.");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getEmp(empId));

				if(dao.getEmp(empId)!=null) {
					System.out.println(dao.getEmp(empId));
				}else {
				System.out.println("조회할 사원이 없습니다.");
				}
			} else if (menu == 3) {
				System.out.println("정보를 수정할 사원번호를 입력하세요.");
				int empId = Integer.parseInt(scn.nextLine());
				System.out.println("새로운 사원이름을 입력하세요.");
				String lastName = scn.nextLine();
				System.out.println("새로운 이메일을 입력하세요.");
				String email = scn.nextLine();
				System.out.println("새로운 입사일자를 입력하세요.");
				String hireDate = scn.nextLine();
				System.out.println("새로운 직무를 입력하세요.");
				String jobId = scn.nextLine();

				Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
				dao.update(emp1);			
				
			} else if (menu == 4) {

					System.out.println("정보를 삭제할 사원번호를 입력하세요.");
					int empId = Integer.parseInt(scn.nextLine());
//					dao.delete(empId);
					if(dao.delete(empId)) {
						System.out.println("정상적으로 삭제");
					}else {
						System.out.println("삭제할 데이터가 없습니다.");	
					}
			
				
			} else if (menu == 5) {
				System.out.println("목록을 조회합니다.");
				List<Employee> employees = dao.search();
				for (Employee emp1 : employees) {
					System.out.println(emp1);
				}
			}else if(menu == 6) {
				System.out.println("일괄등록을 진행합니다.");
				
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}

		}
	}

}
