package co.edu.variable;

public class Account {
	
	private String accNo;  //계좌번호 앞 acc는 어카운트, NO는 번호 자바에서 두단어의 조합: 두번째 단어의 첫글자는 대문자로 작성
	private String owner; //예금주
	private int balance; // 예금액 (잔고)
	

	//getter, setter 메소드를 통해 (값을 입력할 수 있게)접근할 수 있도록 바꿔주어야함.
	void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	String getAccNo() {
		return this.accNo;
	}	
	void setOwner(String owner) {
		this.owner = owner;
	}
	String getOwner() {
		return this.owner;
	}
	
	void setBalance (int balance) {
		this.balance = balance;
	}
	int getBalance() {
		return this.balance;
	}
	
	
	
}
