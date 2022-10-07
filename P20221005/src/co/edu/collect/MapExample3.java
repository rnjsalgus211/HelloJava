package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.Keymap;

class student{
	String name;
	int score;
	
	public student (String name, int score) {
		this.name = name;
		this.score = score;
	}
}


//과제
public class MapExample3 {
	public static void main(String[] args) {
		//1.저장 2.조회 3.종료
		Map<String, Integer> student = new HashMap<>();
		
		Scanner scn = new Scanner(System.in);
		
		while(true){
			System.out.println("1.저장 2.조회 3.종료");
			System.out.print("선택>>>  ");
			
			
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu==1) {
				System.out.println("학생이름입력>>  ");
				String name = scn.nextLine();
				System.out.println("학생점수입력>>  ");
				int score = scn.nextInt();
				student.put(name, score);
				
			}else if (menu == 2) {
				System.out.println("조회할 학생 이름>>>  ");
				String searchName = scn.nextLine();
				Integer score = student.get(searchName);
				System.out.println(searchName+ "의 성적은 " + score);
				System.out.println("점수: "+ student.get(searchName));
			}else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}//end of while
		System.out.println("프로그램 종료");
	}
}
