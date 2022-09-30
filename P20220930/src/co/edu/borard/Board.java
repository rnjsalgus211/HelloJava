package co.edu.borard;

public class Board { //필드만 정의해주면 나머지는 자동완성으로 생성 가능
	private int boardNo; //글 번호
	private String title; //글 제목
	private String content;
	
	public Board() {		
	} //매개 변수 없는 기본 생성자
	
	
	//빈공간 오른쪽 클릭 -> source -> Generate Constructor using field ///자동 생성////
	public Board(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}
	
	
	//빈공간 오른쪽 클릭 -> source -> Generate getters and setters ///자동 생성////
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//source -> generate to String() ///자동 생성////
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
	
}



















