package co.edu;

import java.util.Arrays;

//AppMain2
public class Student {// Student 클래스는 외부 객체에 오픈 되어있습니다.(public) -> AppMain(외부클래스)에서 사용 가능
	//필드
	private String name; //private > 민감한 정보는 숨기겠습니다.라고 하면 AppMain이라는 클래스에서 호출 불가능!!
	private String stuNo;
	private String major;
	private int age; //정수값 자체에는 23, 0, -12라는 값이 들어갈 수 있음. 하지만 -12는 나이값으로 적절하지 않음. private로 묶어주고 메소드로 올바른 필드값을 셋팅해줌
	private String[] hobbies = new String[5];//취미(하나이상의 정보)담을때는 배열로 정해주자. new String[5]로 배열의 크기를 지정해주었음
	
	//static으로 선언된 메소드는 정적메소드.
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}
	
	
	
	//생성자(필드의 값을 초기화 해주는 역할) 따로 정의를 하지 않으면 자바 컴파일러가 기본생성자로 만들어줌
	//생성자의 오버로딩(동일한 이름으로 생성자를 여러번 정의하는것)
	public Student() {//매개값이 없는 생성자=>기본생성자.
		this.name = "기본 값";
		this.stuNo = "000-000";
		
	}
	public Student(String stuNo, String name) {
		this.stuNo = stuNo;
		this.name = name;
	}
	public Student(String stuNo, String name, String major) {
		this(stuNo, name); //기본 생성자를 호출
		this.major = major;
	}

	//캡슐화 
	//배열 타입의 get, set 메소드
	void setHobbies(String[] hobbies) { //매개값으로 들어온 hobbies
//		this.hobbies = hobbies; 이렇게 넣는 순간 배열의 길이가 정해져버림
		//또다른 취미를 추가하고싶을 때 사용하는 메소드
		for(String hobby : hobbies) {
			for(int i=0; i<this.hobbies.length; i++) { //위에 선언되어있는 필드 hobbies
				if(this.hobbies[i] == null) { // 배열 요소가 null이면 (아무것도 들어있지 않으면) 내가 입력한 hobby값을 배열에 추가한다.
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}
	String[] getHobbies() {
		return this.hobbies;
	}
	String getHobb() {
		String str = "취미는 ";
		for(String hobby : hobbies) { //hobbies는 Student 클래스 아래의 항목이다. 배열 요소 만큼 반복해줄게
			if(hobby != null) { //배열의 값을 산출할 때 널이 아닌 경우 추가해줌.
			str += hobby + " ";
			}
		}
		str += "입니다.";
		return str;
	}
	//또다른 취미를 추가하고싶을 때 사용하는 메소드 //적용 안됨
	void addHobby(String hobby) {
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}
	
	//입력된 학번을 가져오는 방법
	void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	String getStuNo() {
		return this.stuNo;
	}
	
	//학생 이름을 위한 set, get메소드
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return this.name;
	}
	
	//전공 set, get메소드
	void setMajor(String major) {
		this.major = major;
	}
	String getMajor() {
		return this.major;
	}
	
//	----------------------------------------------------
	void setAge(int age) { //메소드 매개변수 값은 필드 이름과 동일하게 만들어준다. (age) 이후 필드라는것을 알려주기 위해 this를 붙여줌 매개변수와 필드명이 다를 경우는 상관없음
		if(age < 0) {
			this.age  = 0; //this>> 만들어진 인스턴스 입니다.를 의미
			System.out.println("나이를 올바르게 입력하세요");
		}else {
			this.age = age;
		}
	}
	int getAge() {
		return this.age; // 저장된 age값을 불러오고 싶다면 getAge() 사용
	}		
//	----------------------------------------------------
	// showInfo() 이름,학번,전공을 반환해주는 메소드
	public String showInfo() {
		return "이름은 " + this.name + "이고 "
				+ "학번은 "+ this.stuNo +  
						", 전공은 " + this.major + "입니다";
	}
	
	void study() {
		System.out.println(name +"이(가) 공부를 합니다.");
	}
	void game(String gname) {
		System.out.println(name +"이(가) " +gname+"을(를)합니다." );
	}
	void sleep() {
		System.out.println(name +"이(가) 잠을 잡니다." );
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", stuNo=" + stuNo + ", major=" + major + ", age=" + age + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	
	

}





















