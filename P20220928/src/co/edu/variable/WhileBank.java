package co.edu.variable;

import java.util.Scanner;

public class WhileBank {
	public static void main(String[] args) {
		bankApp();
	}

	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		// 메뉴 1. 입금 2. 출금 3. 잔고 4. 프로그램 종료
		// 10만원이 넘어서면 예금할수 없음
		while (run) {
			System.out.println("1. 입금 2. 출금 3. 잔고 4. 프로그램 종료");
			int menu = scn.nextInt(); // 사용자가 입력한 값을 정수로 받겠다

			switch (menu) {
			case 1:
				System.out.println("입금 메뉴입니다");
				System.out.println("예금액을 입력하세요>>>");
				int input = scn.nextInt();
				if(input+money<=100000) {
				money = money + input;	
				}else {
					System.out.println("더이상 입금할 수 없습니다.");
					System.out.println("현재 잔고는" + money + "원 입니다.");
					System.out.println("처음 화면으로 돌아갑니다.");
				}
				break;
			case 2:
				System.out.println("출금 메뉴입니다");
				System.out.println("출금액을 입력하세요>>>");
				int output = scn.nextInt();
				if(money-output>=5000) {
				money = money - output;
				}else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔고는" + money + "원 입니다.");
					System.out.println("처음 화면으로 돌아갑니다.");
				}
				break;
			case 3:
				System.out.println("잔고 조회 메뉴입니다");
				System.out.println("현재 잔고는" + money + "원입니다.");
				break;
			case 4:
				System.out.println("프로그램을 종료합니다");
				run = false;
				
			}

		} // end of while
		System.out.println("end of program");
	}// end of bankApp

}
