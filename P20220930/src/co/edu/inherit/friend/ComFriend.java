package co.edu.inherit.friend;

public class ComFriend extends Friend{ //Friend 클래스를 상속 받겠습니다. 에러나는 이유 - 생성자부분 정의 안하면 ?
	private String company;
	private String dept;
	
	public ComFriend() { 
		super();
	}
	//값을 초기화하는 생성자   //this는 ComFriend를 가리킴
	public ComFriend(String name, String phone, String company, String dept) {//4개의 매개값을 받는 생성자를 정의
		super(name, phone); //부모 클래스의 생성자를 호출.
		this.company = company;
		this.dept = dept;
		
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCompany() {
		return this.company;
	}
	public String getDept() {
		return this.dept;
	}
	@Override
	public String showInfo() { //name은 Friend 클래스에서 private로 접근 제한이 걸려있기 때문에 getName()메소드로 입력값을 호출할 수 있다.
		//회사 친구의 정보. getName, getPhone 앞에 this가 생략되어있다고 생각하면됨.
		return "회사친구 정보: 이름은 " + getName() + ", 전화번호는 " + getPhone() + 
				", 회사명은 " + this.company + ", 부서는 " + this.dept+ "입니다.";
	}

}
