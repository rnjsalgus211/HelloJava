package SwimmingManagement;

public class Teacher {

	private String tName;
	private String tSex;
	private String tUni;
	private String course;
	
	public Teacher(String tName, String tSex, String tUni, String course) {
		super();
		this.tName = tName;
		this.tSex = tSex;
		this.tUni = tUni;
		this.course = course;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettSex() {
		return tSex;
	}

	public void settSex(String tSex) {
		this.tSex = tSex;
	}

	public String gettUni() {
		return tUni;
	}

	public void settUni(String tUni) {
		this.tUni = tUni;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "[강사명:" + tName +"] [성별:" + tSex + "] [담당 반:" +course+"] [학교 및 학과:" +tUni+ "] ";
	}
	
}
