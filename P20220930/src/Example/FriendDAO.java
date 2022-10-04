package Example;


import java.util.Scanner;

//기능 입력
public class FriendDAO {
	private static FriendDAO instance = new FriendDAO();

	private FriendDAO() {
	}

	public static FriendDAO getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
	Friend[] myFriend = new Friend[100];

	// 1. 연락처 등록(연락처 순서, 이름, 전화번호, 고향)
	public void addPerson() {
		System.out.println("단축번호 몇번에 연락처를 등록하시겠습니까?");
		int num = scn.nextInt();
		scn.nextLine(); //엔터키 소진
		System.out.println("등록할 이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.println("등록할 전화번호를 입력하세요.");
		String phoneNum = scn.nextLine();
		System.out.println("고향을 입력하세요.");
		String home = scn.nextLine();
		
		Friend frd = new Friend(num, name, phoneNum, home);
		
		for(int i=0; i<myFriend.length; i++) {
			if(myFriend[i]==null) {
			   myFriend[i] = frd;
				break;
			}
		}
		
	}

	// 2. 연락처 목록
	public void numList() {
		System.out.println("연락처 목록입니다.");
		for(Friend frd : myFriend) {
			if(frd != null) {
				System.out.println(frd.toString());
			}
		}
	}
	// 3. 연락처 수정
	
	public void numUpdate() {
		System.out.println("연락처를 수정할 이름을 입력하세요.");
		String name1 = scn.nextLine();
		scn.nextLine();
		
		
		boolean update =false;
		for (int i=0; i<myFriend.length; i++) {
			if(myFriend[i] != null && name1.equals(myFriend[i].getName())) {	
				System.out.println("변경할 연락처를 입력하세요.");
				String pNo2 = scn.nextLine();
				myFriend[i].setPhoneNum(pNo2);
				update = true;
				break;
			}
		}
		if(update) {
			System.out.println(name1 + "의 연락처가 수정되었습니다.");
			
		}else {
			System.out.println("찾는 이름이 없습니다.");
		}
	}
	// 4. 정보 상세보기
	public void numDetail() {
		System.out.println("조회할 단축번호를 입력하세요.");
		int pNo = scn.nextInt();
		scn.nextLine(); //엔터키 소진 시키겠습니다.
		for(int i=0; i<myFriend.length; i++) {
			if(pNo == myFriend[i].getNum()) {
				System.out.println(pNo+"번에 등록된 연락처 정보: " + myFriend[i].toString());
				break;
			}
		}
	}

	// 5. 연락처 삭제
	public void delNum() {
		System.out.println("삭제할 단축번호를 선택하세요.");
		int pNo = scn.nextInt();
		scn.nextLine(); // 엔터키 소진
		for(int i=0; i<myFriend.length; i++) {
			if(pNo == myFriend[i].getNum()) {
				System.out.println(pNo + "번에 등록된 " + myFriend[i].getName() + "의 연락처가 삭제되었습니다.");
				myFriend[i] = null;
				break;
			}
		}
	}

	// 6. 전체 메뉴 조회
	public void exe() {
		boolean run = true;

		while (run) {
			System.out.println("1.연락처 등록 2.연락처 조회 3.연락처 수정 4.정보 상세보기 5.연락처 삭제 9.종료");
			System.out.print("선택>>> ");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				addPerson();
				break;
			case 2:
				numList();
				break;
			case 3:
				numUpdate();
				break;
			case 4:
				numDetail();
				break;
			case 5:
				delNum();
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");

			}
		}//end of while문

	}//end of exe
}
