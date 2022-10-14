package co.dev;

import java.util.ArrayList;

public class StudExample {
	public static void main(String[] args) {
//		Student stue = new Student(); 해서 값 일일히 넣어주는것 보다 
		Student stud = new Student(101, "홍길동", 80); //이렇게 하는게 더 간단. new->실체를 하나 만들겠습니다.
//		String name1 = stud; 불가능
//		String name1 = stud.studName; //private 설정하기 전에는 가능.
		
		String name = stud.getstudName();
		int score1 = stud.getScore();
		
		ArrayList<Student> studList = new ArrayList<Student>();
		studList.add(stud);
		studList.add(new Student(102, "김현수", 88));
		studList.add(0, new Student(103, "박문수", 78));
		
		Student hong = new Student (201, "홍수환", 90);//을 김현수 앞에 담고싶을때
		
		for(int i =0; i<studList.size(); i++) {
			if(studList.get(i).getstudName().equals("김현수")) {
				studList.add(i, hong);
				break;
			}
			
		}
		
		//출력. 
		for(int i=0; i<studList.size(); i++) {
			System.out.println(studList.get(i).getstudName());
		}
		//학번 기준으로 정렬되어져있는 값을 담고싶을때
//		ArrayList<Student> sortAry = new ArrayList<Student>();
//		
//		for(int i=0; i<studList.size(); i++) {
//			for(int j =0; j<i; j++) {
//				
			}
		
		
		
		
		
		
		
		

	}

