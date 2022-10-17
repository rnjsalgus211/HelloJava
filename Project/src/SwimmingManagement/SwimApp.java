package SwimmingManagement;

import java.util.List;
import java.util.Scanner;

//실행 클래스
public class SwimApp {
	public static void main(String[] args) {
		SwimDAO swimDao = new SwimDAO();
		Scanner scn = new Scanner(System.in);
		
		//메뉴 1.회원등록 2.조회 3.상세조회 4.정보수정 5.회원정보 삭제 9.종료\\
		
		//로그인 테이블 -> 회원 아이디,비밀번호 제공 /매니저는 매니저 아이디로 로그인.
		
		boolean checked = false;
		String name = null;
		while(!checked) {
			System.out.print("아이디를 입력하세요. ");
			String id = scn.nextLine();
			System.out.print("비밀번호를 입력하세요. ");
			String passwd = scn.nextLine();
			int a = swimDao.login(id, passwd);
			if ( a == 1) {
				name = id;
				System.out.println("******로그인 성공 ! *******");
				break;
			}else {
				System.out.println("******로그인 실패 ******");
				System.out.println("아이디와 비밀번호를 확인하세요!");
				checked = false;
			}
			
		}
		
		
		//본문
		while(true) {
			int menu = 0;
			int menu1 = 0;
			if(name.equals("manager")) {
			System.out.println("<관리자로 접속하였습니다.>");
			System.out.println("1.회원등록 2.조회 3.상세조회 4.정보수정 5.삭제 9.종료");
			System.out.println("입력>>  ");
			menu = Integer.parseInt(scn.nextLine());
			}else {
				System.out.println("<회원으로 접속하였습니다.>");
				System.out.println("1.회원조회 2.강사조회 3.종료" );
				menu1 = Integer.parseInt(scn.nextLine());
				if(menu1==1) {
					System.out.println("회원 목록입니다.");
					List<Swim> swimUser = swimDao.search();
					for(Swim swim1 : swimUser) {
					System.out.println(swim1);
					}
				}else if(menu1==2) {
					System.out.println("강사목록입니다.");
					//강사 테이블 보여주고
//					List<Swim> teachers = swimDao.tInfo();
//					for(Swim teacher : teachers) {
//					System.out.println(teacher);
//					}
					System.out.println("평가를 작성하시겠습니까? Y or N");
					String answer = scn.nextLine();
					if(answer.equals("Y")) {
						
					}else if(answer.equals("N")) {
						System.out.println("처음 메뉴로 돌아갑니다.");
					}else {
						System.out.println("잘못된 응답입니다.");
					}
					
				}else if(menu1==3) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못된 번호입니다.");
				}
			}
			
			Swim swim = null;
			int payment = 0;
			int menu2 = 0;
			String course = "";
			
			//등록
			if(menu ==1) {
				
				System.out.println("회원등록메뉴입니다.");
				System.out.print("회원이름을 입력하세요.");
				String userName = scn.nextLine();
				System.out.print("나이/성별을 입력하세요.");
				String userAge = scn.nextLine();
				System.out.print("휴대폰번호를 입력하세요.");
				String phoneNum = scn.nextLine();
				
				while(true) {
				System.out.print("수강료를 입력하세요. (단위: 만원)");
				payment = Integer.parseInt(scn.nextLine());
				if(payment==5) {
					System.out.println("반을 선택하세요 1.초급 2.중급 3.고급");
					menu2 = Integer.parseInt(scn.nextLine());
					if(menu2==1) {
					course="초급";
					break;
					}else if (menu2==2) {
						course="중급";
						break;
					}else if (menu2==3) {
						course="고급";
						break;
					}else {
						System.out.println("반을 올바르게 선택하세요.");
					}
				}
				}
//				System.out.print("반을 입력하세요. (초급/중급/고급)");
//				String course = scn.nextLine();
				swim = new Swim(0, userName, userAge, phoneNum,payment, course, null);
				swimDao.insert(swim);
				System.out.println("회원정보가 등록되었습니다.");
				
			//조회
			}else if(menu ==2) {
				System.out.println("회원 목록입니다.");
				List<Swim> swimUser = swimDao.search();
				for(Swim swim1 : swimUser) {
				System.out.println(swim1);
				}
			//상세조회
			}else if(menu ==3) {
				System.out.println("회원 번호를 입력하세요.");
				int userSeq = Integer.parseInt(scn.nextLine());
				System.out.println(swimDao.getNum(userSeq).toDetail());
				
				
			//정보수정	
			}else if(menu ==4) {
				System.out.println("정보를 수정 할 회원번호를 입력하세요.");
				int userSeq = Integer.parseInt(scn.nextLine());
				System.out.println(swimDao.getNum(userSeq).toDetail());
				System.out.println("정말 수정하시겠습니까? Y or N");
				String answer1 = scn.nextLine();
				if(answer1.equals("Y")) {
				
				Swim swim2 = swimDao.getNum(userSeq);
				
				if(swim2 !=null) {
					int userNum = userSeq;
					System.out.print("회원이름은?>> ");
					String name1 = scn.nextLine();
					System.out.print("나이는?>> ");
					String age1 = scn.nextLine();
					System.out.print("전화번호는?>> ");
					String num1 = scn.nextLine();
					System.out.println("수강료는?>> ");
					int pay = Integer.parseInt(scn.nextLine());
					System.out.print("수강 코스는?>> ");
					String course1 = scn.nextLine();
					System.out.print("등록일시는?>> ");
					String cDate = scn.nextLine();
					
					swim = new Swim(userNum, name1, age1, num1, pay, course1, cDate);
					swimDao.update(swim);
				}
				}else if(answer1.equals("N")) {
					System.out.println("처음메뉴로 돌아갑니다.");
					continue;
				}else {
					System.out.println("잘못된 명령어입니다.");
				}
			//삭제
			}else if(menu ==5) {
				List<Swim> swimUser = swimDao.search();
				for(Swim swim1 : swimUser) {
				System.out.println(swim1);
				}
				System.out.println("정보를 삭제할 회원 번호를 입력하세요.");
				int userSeq = Integer.parseInt(scn.nextLine());
				Swim swim2 = swimDao.getNum(userSeq);
				if(swim2 != null) {
					System.out.println("정말 삭제하시겠습니까? Y or N");
					String answer2 = scn.nextLine();
					if(answer2.equals("Y")) {
					if(swimDao.delete(userSeq)) {
						System.out.println("정상적으로 삭제.");
					}
					}else if (answer2.equals("N")) {
						System.out.println("처음메뉴로 돌아갑니다.");
						continue;
					}else {
						System.out.println("잘못된 명령어 입니다.");
						continue;
					}
				}else {
					System.out.println("회원 번호를 확인하세요!");
				}
			//종료	
			}else if(menu ==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		scn.close();
		System.out.println("프로그램을 종료합니다.");
	}
	
}