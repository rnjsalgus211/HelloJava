package SwimmingManagement;

public class Reply {

	private String course;
	private String tName;
	private String content;
	private String userName;
	
	
	public Reply(String course, String tName, String content, String userName) {
		super();
		this.course = course;
		this.tName = tName;
		this.content = content;
		this.userName = userName;
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
		
		return course + "코스 " + "강사 이름:"+tName+" 평가내용:"+content+" 작성자:"+userName;
	}
}
