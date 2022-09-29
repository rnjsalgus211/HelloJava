package co.edu.variable;

import java.util.Scanner;

//계좌정보를 선언 : 계좌번호, 예금주, 잔고정보
//은행 계좌 생성 : Account[] banks;
public class WhileBankApp {

	public static void main(String[] args) {
		// 메뉴: 1.입금 2.출금 3.잔액 4.종료
		Account[] banks = new Account[10]; // 어카운트라고 하는 형태의 데이터 타입을 10개 담을수 있는 공간을 작성하겠습니다.

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("0.계좌생성 1.입금 2.출금 3.잔액 4.종료");
			int menu = scn.nextInt();scn.nextLine();
			// true false 이용해서 계좌 안의 정보 스캔하고 동일한 계좌정보 없을 경우 false로 바꿔서 프로그램 종료
			if (menu == 1) {
				// 입금기능. 계좌번호, 얼마 입력?
				System.out.println("계좌번호 >>>");
				String accNo = scn.nextLine();
				System.out.println("입금할 금액>>>");
				int money = scn.nextInt();
				
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNo.equals(accNo)) {
						if(banks[i].balance+money<=100000) {
						banks[i].balance = banks[i].balance + money;// 현재 있는 금액에 예금액을 더해서 저장해준다.
						}else {
							System.out.println("잔액이 10만원을 초과합니다.");
						}
					}
				}
			} else if (menu == 2) {
				System.out.println("계좌번호 >>>");
				String accNo = scn.nextLine();
				System.out.println("출금할 금액>>>");
				int money = scn.nextInt();

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNo.equals(accNo)) {
						if(banks[i].balance>money){
						banks[i].balance = banks[i].balance - money;
					  }else {
						  System.out.println("잔액이 부족합니다.");
					  }
					}
				}
			} else if (menu == 3) {
				System.out.println("조회할 계좌번호 입력>>>");
				String accNo = scn.nextLine();
				for (int i = 0; i < banks.length; i++) { //배열에 입력했던 어카운트 넘버랑 사용자가 입력한 어카운트 넘버가 같은지 확인
					if (banks[i] != null && banks[i].accNo.equals(accNo)) { // != null이라는 조건을 넣어주지 않으면 null값과 비교하게 되기때문에 널 포인트 오류가 발생 
						System.out.println("잔액: " + banks[i].balance);
					}
				}
			} else if (menu == 4) {
				System.out.println("프로그램을 종료하겠습니다.");
				break;
			} else if (menu == 0) {
				System.out.println("계좌번호입력>>>");
				String accNo = scn.nextLine();
				System.out.println("예금주>>>");
				String owner = scn.nextLine();

				Account acc = new Account();// 인스턴스 생성
				acc.accNo = accNo;
				acc.owner = owner;

				// 계좌번호 생성.
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] == null) {
						// 한건입력.
						banks[i] = acc;
						break; // break 안한 경우 인덱스 1~10번까지 똑같은 값을 다 넣어버림 

					}
				}
				System.out.println("계좌생성완료.");
			}

		}
	}
}
