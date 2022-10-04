package Example;

public class FriendExe {
	//실행 클래스 //정보를 담고있는 클래스 Borad, 기능을 담고있는 클래스 BoardDAO
		public static void main(String[] args) {
			FriendDAO dao = FriendDAO.getInstance();
			dao.exe(); //호출해서 프로그램을 시작할게요
	}
}
