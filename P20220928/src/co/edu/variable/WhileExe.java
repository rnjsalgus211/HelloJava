package co.edu.variable;

import java.util.Scanner;

public class WhileExe {

	public static void main(String[] args) {
		whileFnc3(); // 메인메소드에서 호출해보기
	}
	//달력
	public static void whileFnc3() {
		//보고싶은 달을 입력, 종료하고 싶으면 -1를 입력하세요.
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("      월을 선택하세요. 종료는 -1");
//			String input = scn.nextLine();
			int input = scn.nextInt();// 인트 타입 결과 받아야할 때
			if(input ==-1) {
				break;
			}
			MethodCalendar.makeCal(input); //우리가 만들어뒀던 메소드 호출할 수 있음. class.메소드 명
		}
		System.out.println("프로그램이 종료되었습니다.");
		scn.close(); // 스캐너를 종료해주기 오류는 아니지만 해주는게 좋음
	}
	
	public static void whileFnc2() {
		// while 구문. 어떤 조건이 되면 실행하던 프로그램을 멈추겠습니다. (조건에 중점)
		Scanner scn = new Scanner(System.in); // 키보드로부터 입력된 값을 읽어들이겠습니다. impot : ctrl+shf+O(오)
		while (true) {
			System.out.println("값을 입력 하세요. 종료하려면 stop을 입력하세요");
			String inputVal = scn.nextLine();
			if (inputVal.equals("stop")) { // 이 조건을 만족 할 때 while문 빠져나오겠습니다. (사용자가 stop이라는 구문을 넣으면)
				break;
			}
			System.out.println("사용자 입력값>" + inputVal);
		}
		System.out.println("프로그램이 종료되었습니다.");
		scn.close();// 시스템자어ㅜㄴ을 반환

	}

	public static void whileFnc() {
		// for 반복문 (반복 횟수에중점) for(int i=; i<10반복횟수; i++){}
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			i++; // 4보다 작을 때 한번 출력하고 i 값을 1 증가 시키겠습니다.
		}
		System.out.println("//end of program//");
	}

}
