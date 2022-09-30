package co.edu.borard;

public class Friend {
	private int num; //저장할 연락처 공간
	private String name; //이름
	private String phoneNum; //전화번호
	private String home; //고향
	
	public Friend(){ //매개변수 없는 기본 생성자
		
	}

	public Friend(int num, String name, String phoneNum, String home) {
		super();
		this.num = num;
		this.name = name;
		this.phoneNum = phoneNum;
		this.home = home;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "Friend [num=" + num + ", name=" + name + ", phoneNum=" + phoneNum + ", home=" + home + "]";
	}
	
	
	
}
