package SwimmingManagement;


public class Swim {
	private int userSeq;
	private String userName;
	private String userAge;
	private String phoneNum;
	private int payment;
	private String course;
	private String cDate;

	public Swim(int userSeq, String userName, String userAge, String course, String cDate) {
		this.userSeq = userSeq;
		this.userName = userName;
		this.userAge = userAge;
		this.cDate = cDate;
		this.course = course;
	}
	
	public Swim(int userSeq, String userName, String userAge, String phoneNum, int payment, String course, String cDate) {
		super();
		this.userSeq = userSeq;
		this.userName = userName;
		this.userAge = userAge;
		this.phoneNum = phoneNum;
		this.cDate = cDate;
		this.payment = payment;
		this.course = course;
	
		
	}


	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override //번호, 이름, 성별, 등록일시, 반
	public String toString() {
		return "회원번호:" +userSeq+" 회원이름:" +userName + " 성별 및 나이:" + userAge+ " 소속 반:" + course+ " 등록일시:" +cDate; 
	}
	
	public String toDetail() {
		return "회원번호:" +userSeq+" 회원이름:" +userName + " 성별 및 나이:" +userAge 
				+ " 전화번호:" +phoneNum+ " 등록일시:" +cDate
				+" 수강료 납부:"+payment+ "만원"+" 소속 반:" + course; 
	}

}