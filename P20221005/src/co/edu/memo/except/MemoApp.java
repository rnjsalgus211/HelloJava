package co.edu.memo.except;

import java.util.Scanner;

import co.edu.memo.MENU;
import co.edu.memo.MemoManager;

public class MemoApp {
	public static void main(String[] args) {
		MemoManager manager = MemoManager.getInstance();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.println("1.등록 2.검색 3.삭제 4.종료");
			System.out.println("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			
			if(menu < MENU.INSERT || menu > MENU.EXIT) {
				throw new MenuException(menu);
			}
			
			switch(menu)  {
			case MENU.INSERT: //메뉴의 값이 1이면 (MENU라는 인터페이스가 가지고있는 INSERT이면)
				//입력작업. (기능구현해서 넣기)
				manager.inputDate();
				break;
				
			case MENU.SEARCH:
				manager.searchDate();
				//조회
				break;
				
			case MENU.DELETE:
				manager.deleteDate();
				//삭제
				break;
				
			case MENU.EXIT:
				manager.storeToFile();
				//새로운 파일저장.
				throw new ExitException();
			}
			
			}catch(MenuException e) {
				e.showErrMessage(); //MenuException발생하면 에러메세지 띄우겠습니다.
			}catch(ExitException e) {
				break; //while구문을 빠져나오겠습니다.
			}
		}// end of while
		System.out.println("프로그램 종료");
		scn.close(); //스캐너 클래스 리소스를 환원하겠다.??
		
	}
}
