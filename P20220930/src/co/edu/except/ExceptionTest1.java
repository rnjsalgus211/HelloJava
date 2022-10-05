package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

//발생할 수 있는 예외
public class ExceptionTest1 {
	public static void main(String[] args) {

		// null pointer 참조
		String str = "Hello World!!";
		// 예외처리. RuntimeException을 상속받아서 처리 하는 예외 클래스
		try {
			String result = str.substring(0, 10);
			char chr = result.charAt(20);// CharAt(인덱스값); char는 정수타입
			System.out.println(chr);
		} catch (NullPointerException e) { // try 실행문에서 예외가 발생하면 catch구문 안에 있는 것을 실행시킨다. null포인트 예외만 예외처리하였기때문에 오류
			System.out.println("참조하는 값이 없습니다.");
		} catch (StringIndexOutOfBoundsException e1) {
			System.out.println("인덱스 범위를 벗어난 값입니다.");
		} catch (RuntimeException e2) {
			System.out.println("실행 예외가 발생했습니다.");
		} catch (Exception e3) {
			System.out.println("알수없는 예외가 발생했습니다.");
		}

		// 일반예외 : Exception을 상속받아서 처리 하는 예외 클래스
		try {
			Class.forName("java.lang.String"); // 예외 발생
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("숫자 입력>>  ");
			try {
				int menu = scn.nextInt(); // InputMismatchException
				System.out.println("입력 값은: " + menu);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요!");
				scn.nextLine(); //abc (Enter)
			}finally {
				System.out.println("반드시 실행할 코드입니다.");
				//db 컬렉션 실행하고 반환
			}
		}
		try {
		exceptMethod(); //클래스 인스턴스 하나 호출하는 기능
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}// end of main()
	
	
	
	//예외 떠넘기기 
	public static void exceptMethod() throws ClassNotFoundException {
		// 일반예외 : Exception을 상속받아서 처리 하는 예외 클래스
//		try {
			Class.forName("java.lang.String"); // 예외 발생
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}