package co.edu.inherit.friend;

import co.edu.borard.BoardDAO;

public class FriendApp {
	public static void main(String [] args) {
			FriendExe dao = FriendExe.getInstance();
			dao.exe(); //호출해서 프로그램을 시작할게요
		}
		//친구
//		Friend frnd = new Friend("홍길동", "010-1231-4155"); //값을 바로 넣어주어도 가능
////		frnd.setName("홍길동");
////		frnd.setPhone("010-1231-4155");
//		
//		UnivFriend univFrnd = new UnivFriend("김민규", "010-2115-8969", "대구대학교", "역사학과");
//		ComFriend comFrnd = new ComFriend("유재석", "010-5128-4930", "MBC", "미디어부서");
//		
//		Friend[] friends = new Friend[5]; //부모클래스의 참조값을 담도록 배열을 선언.
//		friends[0] = frnd;
//		friends[1] = univFrnd;
//		friends[2] = comFrnd;
//				
//		for(Friend friend : friends) { //showInfo라는 메소드를 오버라이딩 해두었음
//			if(friend != null)
//			System.out.println(friend.showInfo());
//		}
		
	}
//}
