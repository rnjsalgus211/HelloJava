package co.edu.board;

import java.util.List;
import java.util.Scanner;

import co.edu.jdbc.Employee;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO boardDao = new BoardDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴 1.글 등록 2.글 상세조회 3.글 수정 4.글 삭제 5.글 목록 9.종료

		boolean checked = false;
		String name = null;
		while (!checked) {
			System.out.println("아이디를 입력하세요.");
			String id = scn.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String passwd = scn.nextLine();
			int a = boardDao.login(id, passwd);
			if (a == 1) {
				name = id;
				System.out.println("*****로그인 성공!*****");
				break;
			} else {
				System.out.println("*****로그인 실패*****");
				System.out.println("아이디와 비밀번호를 확인하세요 !");
				checked = false;
			}

		}

		while (true) {
			System.out.println();
			System.out.println("1.글 등록 2.글 수정 3.글 삭제 4.글 목록 5.글 상세조회 9.종료");
			System.out.println("입력>>  ");
			int menu = Integer.parseInt(scn.nextLine());
			Board brd = null;

			if (menu == 1) {
				System.out.println("글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.println("글제목을 입력하세요.");
				String bTitle = scn.nextLine();
				System.out.println("글내용을 입력하세요.");
				String bContent = scn.nextLine();
//				System.out.println("작성자를 입력하세요.");
				String bWriter = name;
				String cDate = null;
//				System.out.println("작성일자를 입력하세요.");
//				String cDate = scn.nextLine();
				int cnt = 0;

				brd = new Board(bNum, bTitle, bContent, bWriter, cDate, cnt);
				boardDao.insert(brd);

			} else if (menu == 2) {
				System.out.println("내용을 수정 할 글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				Board brd2 = boardDao.getNum(bNum);

				if (brd2 != null) {
					if (name.equals(brd2.getbWriter())) {
						System.out.println("글내용을 입력하세요.");
						String bContent = scn.nextLine();
						brd = new Board(bNum, bContent);
						boardDao.update(brd);
					} else {
						System.out.println("권한이 없습니다.");
					}
				}

			} else if (menu == 3) {
				System.out.println("정보를 삭제할 글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
//				String name2 = brd.getbWriter();
				Board brd2 = boardDao.getNum(bNum);
				if (brd2 != null) {
					if (name.equals(brd2.getbWriter())) {
						if (boardDao.delete(bNum)) {
							System.out.println("정상적으로 삭제");
						}
					} else {
						System.out.println("삭제가 불가능합니다.");
					}

				} else {
					System.out.println("글 번호를 확인하세요");
				}

			} else if (menu == 4) {
				System.out.println("글 목록을 조회합니다.");
				List<Board> board = boardDao.search();

				while (true) {
					for (int i = 0; i < 3; i++) {
						System.out.println(board.get(i).toDetail());
					}
					System.out.println("1페이지 입니다.");

					System.out.println("다음 페이지? Y or N");
					String an = scn.nextLine();
					if (an.equals("Y")) {
						for (int i = 3; i < 6; i++) {
							System.out.println(board.get(i).toDetail());

						}
						System.out.println("2페이지 입니다.");
					} else if (an.equals("N")) {
						break;
					}
					System.out.println("다음 페이지? Y or N");
					an = scn.nextLine();
					if (an.equals("Y")) {
						for (int i = 6; i <9; i++) {
							System.out.println(board.get(i).toDetail());

						}
						System.out.println("3페이지 입니다.");
					}	break;	

				}

//				int p = 0;
//				for(int i =0; i<board.size(); i++) {
//					System.out.println(board.get(i).toDetail());
//					p++;
//				}System.out.println("글 갯수는" + p+ "개");
//				
//				for (Board brd1 : board) {
//					System.out.println(brd1.toDetail());
//				}

			} else if (menu == 5) { // 상세보기
				System.out.println("조회 할 글번호를 입력하세요.");
				int bNum = Integer.parseInt(scn.nextLine());
				System.out.println(boardDao.getNum(bNum));
				System.out.println("댓글 목록.");
				List<Reply> rep = boardDao.repSearch(bNum);
				for (Reply repl : rep) {
					System.out.println(repl.toString());
				}
				System.out.println("댓글을 달려면 1, 삭제하려면 2, 종료하려면 0을 입력하세요.");
				int reply = Integer.parseInt(scn.nextLine());
				if (reply == 1) {
					System.out.println("댓글 내용을 입력하세요.");
					String repCon = scn.nextLine();
					Reply re = new Reply(0, bNum, repCon, name, null);
					boardDao.reply(re);
					System.out.println("댓글 작성이 완료되었습니다.");

				} else if (reply == 2) {
					System.out.println("삭제할 댓글 번호를 입력하세요.");
					int rNum = Integer.parseInt(scn.nextLine());
					boardDao.repDelete(rNum);
					System.out.println("삭제가 완료되었습니다.");
				}

				else if (reply == 0) {
					System.out.println("처음화면으로 돌아갑니다.");
					continue;
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		}
	}
}
