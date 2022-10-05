package co.edu.emp;

import java.util.Scanner;


//메인클래스
public class EmployeeApp {
	public static void main(String[] args) {
		//1.사원수(초기화: 배열 크기지정) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
		Scanner scn = new Scanner(System.in);
		EmployeeService service = new EmployeeArrayList2Answer(); //EmployeeArrayList로 수정하면 컬렉션을 활용해서 기능을 사용할수있음.
		
		while(true) {
			System.out.println("1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 5.급여 9.종료");
			System.out.print("선택 >>> ");
			
			 //"1" -> 1 문자열을 숫자로 바꿔주는 기능을 넣어주자
			try {
				int menu = Integer.parseInt(scn.nextLine());
			if(menu==1) {
				service.init();
			}else if(menu==2) {
				service.input();
			}else if(menu==3) {
				System.out.println("정보를 볼 사원번호를 입력하세요.");
				int eId = Integer.parseInt(scn.nextLine()); //"100" Enter. 까지 입력받음
				String name = service.search(eId);
				
				if(name == null) {
					System.out.println("찾는 사원 정보가 없습니다.");
				}else {
					System.out.println("사원의 이름은 " + name);
			
				}
			}else if(menu==4) {
				service.print();
			}else if(menu==5) {
				System.out.println("급여정보를 볼 사원번호를 입력하세요.");
				int eId = Integer.parseInt(scn.nextLine());
				int salary = service.searchSal(eId);
				if(salary== -1) {
					System.out.println("찾는 사원정보가 없습니다.");
				}else {
					System.out.println("사원의 급여는 "+ salary);
				}
				
			}else if(menu==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		}
		System.out.println("프로그램 종료");
	}//end of main()
}//end of class
