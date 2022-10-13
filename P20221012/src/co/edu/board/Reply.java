package co.edu.board;

public class Reply {
	private int repNum;
	private int boardNum;
	private String repCon;
	private String repWriter;
	private String cDate;
	
	public Reply(int repNum, int boardNum, String repCon, String repWriter, String cDate) {
		super();
		this.repNum = repNum;
		this.boardNum = boardNum;
		this.repCon = repCon;
		this.repWriter = repWriter;
		this.cDate = cDate;
	}

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getRepCon() {
		return repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	
	
	@Override
	public String toString() {
		return "글번호: " + boardNum+ "의 댓글번호: " + repNum + ", 댓글 내용: " + repCon //
				+", 댓글 작성자: " + repWriter + ", 작성일시: " + cDate;
	}
	
}
