package co.edu.board;

import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO boardDao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		
		//메뉴 1.글 등록 2.글 상세조회 3.글 수정 4.글 삭제 5.글 목록 9.종료
		
		
		while(true) {
			System.out.println("1.글 등록 2.글 상세조회 3.글 수정 4.글 삭제 5.글 목록 9.종료");
			System.out.println("입력>>  ");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu ==1) {
				System.out.println("글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.println("글제목을 입력하세요.");
				String bTitle = scn.nextLine();
				System.out.println("글내용을 입력하세요.");
				String bContent = scn.nextLine();
				System.out.println("작성자를 입력하세요.");
				String bWriter = scn.nextLine();
				System.out.println("작성일자를 입력하세요.");
				String cDate = scn.nextLine();
				int cnt = 0;

				Board brd = new Board(bNum, bTitle, bContent, bWriter, cDate, cnt);
				boardDao.insert(brd);
			}else if(menu ==2) {
				System.out.println("조회 할 글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.println(boardDao.getNum(bNum));
			}else if(menu ==3) {
				System.out.println("내용을 수정 할 글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.println("글내용을 입력하세요.");
				String bContent = scn.nextLine();
				
//				Board brd = new Board(bNum, bContent);
//				boardDao.update(brd);
			}else if(menu ==4) {
				
			}else if(menu ==5) {
				System.out.println("글 목록을 조회합니다.");
				List<Board> board = boardDao.search();
				for (Board brd : board) {
					System.out.println(brd);
				}
			}else if (menu==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		}
	}
}
