package co.edu.inherit.friend;

public class UnivFriend extends Friend {
	
	private String univ; //학교명
	private String major;
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); // Friend(String name, String phone)을 호출하는 것
		this.univ = univ;
		this.major = major;
	}
	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	
	@Override
	public String showInfo() {
		return "학교친구 정보: 이름은 " + getName() + ", 연락처는 " + getPhone() + ", 학교명은 " + this.univ + ", 전공은 " + this.major ;
		
	}
}
