package co.edu.borard;

import java.util.Scanner;

//기능만 넣겠다 Board 클래스 사용
public class BoardDAO {
	private static BoardDAO instance = new BoardDAO(); //static은 클래스에 소속되어있어서 여러개를 만들지 못하게 막아줌 /정적 필드
	private BoardDAO() {} //외부에서 생성자에 접근할수없음
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100]; //보드라는 클래스에 인스턴스를 담기위한 100개짜리의 배열공간
	// 1. 글 등록
	public void addBoard() {
		System.out.println("글을 등록하려면");
		System.out.print("글번호를 입력하세요.>>>");
		int bNo = scn.nextInt();
		scn.nextLine(); //엔터키 소진 시키겠습니다.
		System.out.print("글 제목을 입력하세요.>>>");
		String title = scn.nextLine();
		System.out.print("글 내용을 입력하세요.>>>");
		String content = scn.nextLine();
		
		Board brd = new Board(bNo, title, content); //생성자를 통해 값을 초기화
		//배열 등록
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] ==null) {
				myBoards[i] = brd;
				break;
			}
		}System.out.println("-------글 등록이 완료되었습니다-------");
	}
	
	// 2. 글 목록
	public void boardList() {
		System.out.println("글 목록입니다");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
	}
	
	// 3. 글 상세보기
	public void boardDetail() {
		System.out.println("상세 보기");
		System.out.print("내용을 보고싶은 글번호를 입력하세요.>>>");
		int bNo = scn.nextInt();
		scn.nextLine(); //엔터키 소진 시키겠습니다.
		for(int i=0; i<myBoards.length; i++) {
			if(bNo == myBoards[i].getBoardNo()) {
				System.out.println(bNo+"번 글 상세 내용: " + myBoards[i].getContent());
				break;
			}
		}
	}

	// 4. 글 삭제
	
	public void delBoard() {
		System.out.println("글 삭제 기능");
		System.out.print("삭제할 글번호를 입력하세요.>>>");
		int bNo = scn.nextInt();
		scn.nextLine(); //엔터키 소진 시키겠습니다.
		for(int i=0; i<myBoards.length; i++) {
			if(bNo == myBoards[i].getBoardNo()) {
			    myBoards[i] =null;
				System.out.println(bNo +"번 글이 선택되었습니다.");
				System.out.println("-------글 삭제가 완료되었습니다-------");
				break;
				
			}
		}
	}

	// 5. 전체 메뉴 리턴 타입은 없음
	public void exe() {
		boolean run = true;
		// while 반복문 쓰는 이유 : 종료하는 조건을 사용자가 정하겠다
		while (run) {
			System.out.println("1.글 등록 2.글 목록 3.글 상세보기 4.글 삭제 9.종료");
			System.out.print("선택>>> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: addBoard(); break;
			case 2: boardList(); break;
			case 3: boardDetail(); break;
			case 4: delBoard(); break;
			case 9: run = false; break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		} // end of while
		System.out.println("프로그램이 종료되었습니다.");
	}// end of exe()
}
