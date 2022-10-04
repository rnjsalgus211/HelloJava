package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	private static FriendExe instance = new FriendExe();

	FriendExe() {
	}

	public static FriendExe getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList(); // ctrl + shift + o

	// 친구등록 - 학교/회사/친구...
	public void exe() {

		while (true) {
			System.out.println("1.친구 등록 2.친구 조회 3.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("1.회사 2.학교 3.일반");
				int subMenu = scn.nextInt();
				scn.nextLine();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				} // subMenu 끝나는 지점

			} else if (menu == 2) {
				searchFriend();

			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		} // while문 종료
		System.out.println("프로그램 종료.");

	}// end of exe()

	// 추가메소드.
	// 회사 친구 정보
	public void addComFriend() {
		System.out.println("회사친구의 이름을 입력하세요");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phone = scn.nextLine();
		System.out.println("회사명을 입력하세요.");
		String company = scn.nextLine();
		System.out.println("부서를 입력하세요.");
		String dept = scn.nextLine();

		ComFriend comFrd = new ComFriend(name, phone, company, dept);

		friends.add(comFrd);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = comFrd;
//				break;
//			}
//		}
		
		System.out.println("회사친구 정보가 등록되었습니다.");
	}

	// 학교친구
	public void addUnivFriend() {
		System.out.println("학교친구의 이름을 입력하세요.");
		String name1 = scn.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phone1 = scn.nextLine();
		System.out.println("학교명을 입력하세요.");
		String univ = scn.nextLine();
		System.out.println("전공을 입력하세요.");
		String major = scn.nextLine();

		UnivFriend univFrd = new UnivFriend(name1, phone1, univ, major);

		friends.add(univFrd);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = univFrd;
//				break;
//			}
//		}
		System.out.println("학교친구 정보가 등록되었습니다.");

	}

	// 친구
	public void addFriend() {
		System.out.println("친구의 이름을 입력하세요.");
		String name2 = scn.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phone2 = scn.nextLine();

		Friend frd = new Friend(name2, phone2);
		friends.add(frd);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = frd;
//				break;
//			}
//		}
		System.out.println("친구 정보가 등록되었습니다.");
	}

	// 등록된 친구 정보 조회
	// 권수미,권미현,강민기 ( 이름이 똑같지 않더라도 겹치는 글자가 있으면 산출되도록)
	public void searchFriend() {
		System.out.print("친구 정보를 조회합니다.>>");
		System.out.println("조회할 친구의 이름을 입력하세요.");
		String name1 = scn.nextLine();
		
		
		//Friend 클래스의 상속. Friend, ComFriend, UnivFriend의 인스턴스
		for(int i=0; i<friends.size(); i++) {
			Object frnd = friends.get(i); //Object
			if(frnd instanceof Friend) {
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
				
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
				
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
//			if(friends.get(i)!=null && name1.equals(friends.get(i))) {
//				System.out.println(friends.get(i));
//			}
//			Friend frnd = (Friend)friends.get(i);
//			System.out.println(frnd.showInfo());
			//어느 클래스인지 모르는데 Friend로 정해주면 Friend클래스가 가지고있는 showInfo만 실행이됨
			//경우에따라 Friend, ComFriend, UnivFriend가 선택되어지도록 
		}
//		boolean view = false;
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] != null && friends[i].getName().contains(name1)) {// contains(name1) name1에 입력된 글자 중 하나라도 포함
//																				// 된 경우
//				System.out.println(friends[i].showInfo());
//				System.out.println("정보 조회가 완료되었습니다.");
//				view = true;
//				break;
//			}
//			if(view) {
//				System.out.println("메뉴로 돌아갑니다.");
//				break;
//			}else {
//				System.out.println("찾는 정보가 없습니다.");
//				view = false;
//				break;
//			}
//		}

	}
}
