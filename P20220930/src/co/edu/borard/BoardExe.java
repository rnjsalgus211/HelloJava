package co.edu.borard;

//실행 클래스 //정보를 담고있는 클래스 Borad, 기능을 담고있는 클래스 BoardDAO
public class BoardExe {
	public static void main(String[] args) {
//		BoardDAO dao = new BoardDAO(); //기능 담고있는 인스턴스 호출?
		BoardDAO dao = BoardDAO.getInstance();
		dao.exe(); //호출해서 프로그램을 시작할게요
	}
}
