package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar {
	//메소드를 생성 하고 나서 호출은 메인 메소드 내에서 할 수 있음.
	private static MethodCalendar instance = new MethodCalendar();
	private MethodCalendar() {}
	public static MethodCalendar getInstance() { 
		return instance;
	}
	
	
	public  void makeCal(int years ,int month) {
		System.out.println("           "+ years+"년 "+ month+"월"+"      ");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {// days라는 배열에 들어있는 요소 갯수만큼 반복해서 받아온뒤 day에 하나씩 저장하겠다
			System.out.printf("%4s", day); // 문자열 타입일때 4s 4개의 문자열을 포함해서 출력하겠다
		}
		System.out.println(); //한줄 띄우기
		// 1일의 위치 지정

		for (int i = 0; i < getFirstDay(years,month); i++) { 
			System.out.printf("%4s", " ");
		}

		for (int i = 1; i <= getLastDate(years,month); i++) { //얘는 줄바꿈 담당
			System.out.printf("%4d", i); // 숫자 타입일 때 4d (4자리 너비만큼)
			if ((i + getFirstDay(years,month)) % 7 == 0) {
				System.out.println();
			}
		}
	}// end of makeCal()
	
	public int getFirstDay(int years, int month) {  //9월달이라는 값을 넣어주면
		Calendar cal = Calendar.getInstance();
		cal.set(years, month-1, 1); //년 정보 지정
		return cal.get(Calendar.DAY_OF_WEEK) - 1 ;
		//프로그램 상에서 1은 일요일이지만 우리가 설정한 실행문상에서는 0이 일요일이기때문에 결과값에서 -1을 해줘야 1이 일요일로 리턴됨.
	} //end of getFristDay
	
	public int getLastDate(int years, int month) {
		// switch.. case.. 구문
		Calendar cal = Calendar.getInstance();
		cal.set(years, month-1, 1);
		return cal.getActualMaximum(Calendar.DATE);
	}
	
	
}// end of class.
