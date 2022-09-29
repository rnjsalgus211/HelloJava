package co.edu.variable;

public class MethodCalendar {
	//메소드를 생성 하고 나서 호출은 메인 메소드 내에서 할 수 있음.
	public static void main(String[] args) {
		makeCal(9);// 호출
	}

	public static void makeCal(int month) {

		System.out.println("            ♥ "+month+"월"+" ♥      ");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {// days라는 배열에 들어있는 요소 갯수만큼 반복해서 받아온뒤 day에 하나씩 저장하겠다
			System.out.printf("%4s", day); // 문자열 타입일때 4s 4개의 문자열을 포함해서 출력하겠다
		}
		System.out.println(); //한줄 띄우기
		// 1일의 위치 지정.
		for (int i = 0; i < getFirstDay(month); i++) { 
			System.out.printf("%4s", " ");
		}
		for (int i = 1; i <= getLastDate(month); i++) { //얘는 줄바꿈 담당
			System.out.printf("%4d", i); // 숫자 타입일 때 4d (4자리 너비만큼)
			if ((i + getFirstDay(month)) % 7 == 0) {
				System.out.println();
			}
		}
	}// end of makeCal()
	
	public static int getFirstDay(int month) {  //9월달이라는 값을 넣어주면
		if(month == 9) {
			return 4;
		}else if (month ==8) {
			return 1;
		}else if (month ==7) {
			return 5;
		}else if (month ==6) {
			return 3;
		}
		
		else {
			return 0;
		}
	} //end of getFristDay
	
	public static int getLastDate(int month) {
		// switch.. case.. 구문
		switch (month) {
		case 9:
			return 30;
		case 8:
			return 31;
		case 7:
			return 31;
		case 6:
			return 30;
		default:
			return 30;
		}
	}
	
	
}// end of class.
