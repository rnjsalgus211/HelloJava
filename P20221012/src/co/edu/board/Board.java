package co.edu.board;

public class Board {
	private String userId;
	private String passwd;
	private int bNum;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String cDate;
	private int bCnt;
	

	public Board (int bNum, String bContent) {
		this.bNum = bNum;
		this.bContent = bContent;
	}
	public Board (int bNum, String bTitle, String bWriter, String cDate) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.cDate = cDate;
		
		
	}
	public Board(String userId, String passwd, int bNum, String bTitle, String bContent, String bWriter, String cDate,
			int bCnt) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.cDate = cDate;
		this.bCnt = bCnt;
	}
	public Board (int bNum, String bTitle, String bContent, String bWriter, String cDate, int bCnt ) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.cDate = cDate;
		this.bCnt = bCnt;
		
		
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	
	public String toDetail() {
		return "글번호: " +bNum+", 글제목: " +bTitle+ " 작성자: "+bWriter+" 작성일시: "+ cDate;
	}
	
	
}
