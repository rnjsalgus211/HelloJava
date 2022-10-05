package co.edu.emp.list;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		today.set(2020, 1, 1); //Month 0이 1월 9는 10월 
		
		System.out.println("요일정보: " + today.get(Calendar.DAY_OF_WEEK)); //일1, 월2, 화3, 수4 ....
		System.out.println("날짜정보: " + today.get(Calendar.DATE)); //일
		System.out.println("월 정보: " + (today.get(Calendar.MONTH)+1)); //월
		System.out.println("월말정보: " + today.getActualMaximum(Calendar.DATE)); 
		
		
	}
}
