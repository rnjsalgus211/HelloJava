package co.edu;
//Student 클래스 사용
public class AppMain2 {
	public static void main(String[] args) {
		
		
		Student.staticMethod(); //인스턴스 안만들어도 메모리상에서 사용할 준비 되어있다. 클래스이름.메소드이름 형식으로 사용
	
		Math.random(); //정적 메소드 0~1 임의의 값 생성해준다.
		Math.round(.5);// 반올림
		
		
		Student s1 = new Student();
//		s1.staticMethod(); //에러는 아닌데 노란줄 그어짐 warning<<
		s1.setStuNo("18071824");
		s1.setName("홍길동");
		s1.setMajor("컴퓨터공학");
		s1.setAge(20);
		
		System.out.println(s1.getStuNo()); //타입 string, 아무런 값을 넣지 않았을 경우 초기값 출력 null
		System.out.println(s1.getAge()); //기본 타입 int , 기본값 0
		System.out.println(s1.showInfo());
		
		System.out.println("여기 =>>>>" + s1); //주소값 리턴
		
		
		
		Student s2 = new Student();
		s2.setName("김민숙");
		s2.setStuNo("11240810");
		s2.setMajor("역사학과");
		System.out.println(s2.showInfo());
		
		String[] hob = {"독서", "자전거"};
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());
		
		System.out.println(s2.getHobb());
		
		Student s3 = new Student(); //생성자를 정의해주었기 때문에 '기본값'을 가져옴
		System.out.println(s3.getName());
		
		Student s4 = new Student("111-234", "주소영");
		System.out.println(s4.showInfo());
		
		Student s5 = new Student("1705317", "송지은", "역사학과");
		System.out.println(s5.showInfo());
	}
}












