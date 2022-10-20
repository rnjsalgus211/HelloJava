package SwimmingManagement;

public class Reply {
	private int repNum;
	private String course;
	private String tName;
	private String content;
	private String userName;
	
	
	public Reply(int repNum, String course, String tName, String content, String userName) {
		super();
		this.repNum = repNum;
		this.course = course;
		this.tName = tName;
		this.content = content;
		this.userName = userName;
	}

	
	public int getRepNum() {
		return repNum;
	}


	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		
		return "[번호:"+repNum + "] [강사명:"+tName+"("+course+")"+"] [작성자:"+userName+"]  [평가내용:"+content+"]";
	}
}
