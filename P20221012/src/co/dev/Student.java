package co.dev;

public class Student {
	private int studNo;
	private String studName;
	private int score;
	
	
	Student(int studNo, String studName, int score){
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}
	
	public void setStudNo(int studNo) { //매개값(studNo)을 받아와서 필드에다가 넣어주겠습니다.
		this.studNo = studNo;  //this-> 자기자신.
	}
	public void setStudName(String studName) {
		this.studName = studName;  
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getStudNo() { //매개값X 반환값은 설정.
		return studNo;
	}
	public String getstudName() {
		return studName;
	}
	public int getScore() {
		return score;
	}
	
}


