package co.edu.inherit.friend;

public class Friend { //final이 들어가면 상속할 수 없음. public final class Friend
	private String name; //필드 정의(외부클래스에서 사용할수 X)
	private String phone;
	
	public Friend() {} //기본 생성자 정의 -> 없으면 컴파일러가 자동으로 만들어주는데 왜 정의?
	//생성자 자동완성
	public Friend(String name, String phone) { //생성자 정의
		super(); //Object 클래스의 생성자를 호출 (없어도 상관은 X)
		this.name = name;
		this.phone = phone;
	}
	//메소드 정의
	public void setName(String name) {
		this.name = name; //name이라는 필드에 매개값으로 들어온 값을 넣어주기
	}
	public void setPhone(String phone) {
		this.phone = phone; 
	}
	public String getName() {
		return this.name; //name 필드를 반환 해주는 메소드
	}
	public String getPhone() {
		return this.phone;  //phone 필드를 반환
	}
	public String showInfo() {
		return "친구 정보: 이름은 " + name + ", 연락처는 " + phone;
	}
	
	//-----------------------------------------
}
