package SwimmingManagement;

public class Login {
	private String userId;
	private String passwd;
	private String userName;
	private String userEmail;
	
	public Login(String userId, String passwd, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userEmail = userEmail;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "로그인정보: [Id=" + userId + ", passwd=" + passwd + ", userName=" + userName + ", userEmail=" + userEmail
				+ "]";
	}
	
	public String toDetail() {
		return "로그인정보: [Id=" + userId + ", 이름=" +userName + ", 이메일=" + userEmail +"]";
	} 
	
}
