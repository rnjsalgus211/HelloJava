package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화";
//		flowers[3] = "목련"; //문법상으로는 오류가 아님. 하지만 실행시 오류
		
		//flowers2 선언. flower에 있던 요소들을 빼와서 담을수있도록
		
		String[] flowers2 = new String[6];
		
		
		for(String str : flowers2) {
			if (str != null) {
				System.out.println(str);
			}
		}
		//배열의 크기 고정-> 컬렉션(ArrayList);
		//ArrayList 는 데이터 타입이 Object(모든 데이터 타입을 저장할 수 있음) // 모든 클래스의 최상위 클래스
		ArrayList flowers3 = new ArrayList(); //import 해주어야함 , 크기 따로 지정안했을 경우 10개짜리 공간 생성 10개 다차면 20개로 늘어남
		flowers3.add("국화꽃"); //첫번째 위치에 장미 저장.
		flowers3.add("유채꽃");
		flowers3.add("복사꽃");
//		flowers3.add(123);
		for(Object str : flowers3) { 
			String result = (String) str;
			System.out.println(result);
			
		}
		//컬렉션의 크기
		for(int i=0; i<flowers3.size(); i++) { //length 대신 size() 사용 , ArrayList배열처럼 생긴 클래스이기 때문
			String result = (String)flowers3.get(i); //String 타입으로 형변환
			System.out.println(result);
		}
		
		
	}
}
