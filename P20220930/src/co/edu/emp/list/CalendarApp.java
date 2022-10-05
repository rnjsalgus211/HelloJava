package co.edu.emp.list;

import java.util.Calendar;

public class CalendarApp {
	public static void main(String[] args) {
		MethodCalendar cal = MethodCalendar.getInstance(); //new Calendar로 생성할 수 없음 Calendar.getInstance()는 싱글톤 방식으로 호출 가능
		cal.makeCal(2020 ,2);
		
	}
}
