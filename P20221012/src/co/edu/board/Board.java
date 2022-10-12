package co.edu.board;

public class Board {
	private int bNum;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String cDate;
	private int bCnt;
	
	public Board() {
		
	}
	
	public Board (int bNum, String bTitle, String bWriter, String cDate) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.cDate = cDate;
		
		
	}
	public Board (int bNum, String bTitle, String bContent, String bWriter, String cDate, int bCnt ) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.cDate = cDate;
		this.bCnt = bCnt;
		
		
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public int getbCnt() {
		return bCnt;
	}

	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}
	
	@Override
	public String toString() {
		return "글번호: " +bNum+ ", 글제목: "+bTitle+ ", 글내용: "+bContent//
				+", 작성자: " +bWriter+", 작성일시: "+cDate+", 읽은 횟수: " + bCnt;
		
	}
	
	
}
