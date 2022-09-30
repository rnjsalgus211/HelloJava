package co.edu;

//하나의 실행 클래스(메인 메소드를 가진 클래스)와 여러개의 라이브러리용 클래스가 필요함
public class AppMain {
	public static void main(String[] args) {
		// 실체를 만드는 작업
		// Object  -> Class -> Instance 어떻게 생성하는지 기억하기
//		Person kim = new Person(); //인스턴스 생성.
//		kim.name = "김민기";
//		kim.age = 20;
//		kim.sleep();  //기능을 수정하고 싶을 때는 적용되어있는 클래스로 돌아가서 수정해주어야함.
//		kim.eat("포도");
//		
//		Person lee = new Person();
//		lee.name = "이순신";
//		lee.age = 55;
//		lee.run();
//		lee.sleep();
//				
//		System.out.println(kim); //co.edu.Person(라는객체가)@1d8d30f7(위치에 만들어짐)
		
		Student stud1 = new Student();
//		stud1.name = "권미현";
		stud1.setName("권미현");
//		stud1.stuNo = 14112804;
		stud1.setStuNo("14112804"); //메소드의 매개값으로 입력해주어야함 주의!!!!!!!!!!
//		stud1.major = "컴공";
		stud1.setMajor("언어치료");
		stud1.study();
		stud1.game("메이플");
		stud1.sleep();
	
		Student stud2 = new Student();
		stud2.setName("차은우");
		stud2.setStuNo("14학번");
		stud2.setMajor("경영학과");
		stud2.study();
		stud2.game("롤");
		stud2.sleep();
		
		Student stud3 = new Student();
		
		//인스턴스를 배열로 만들어서 출력하는 방법
		Student[] students;
		students = new Student[] {stud1, stud2, stud3};
		for(Student stud : students) { //students 배열에 들어있는 요소들을 불러들여서 stud에 저장하겠다
			System.out.println("이름:" + stud.getName() + " 학번:" + stud.getStuNo() + " 전공:" + stud.getMajor());
			
		}
		
		
		//상속 Person<<부모 기능 그대로 물려받음
		WorkMan wman = new WorkMan(); 
		wman.name ="직장인"; //WorkMan에 name이 없는데도 Person(부모클래스)에 있기 때문에 상속받아서 사용가능함.
		wman.age = 30;
				
		StudMan sman = new StudMan();
		sman.school ="고등학교";
		sman.height = 164.3;
		
		
	}
}



















