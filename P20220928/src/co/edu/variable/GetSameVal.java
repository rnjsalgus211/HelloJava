package co.edu.variable;

import java.util.Scanner;// import해야되는이유 -> 베이스 패키지 이외의 다른 패키지는 추가해주어야 패키지 안의 클래스를 사용할수 있음. 
import java.lang.System;// 베이스 패키지
//java.lang 이 베이스 패키지. System.out.println에서 System도 클래스 (첫글자 대문자)

public class GetSameVal {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in); // 사용자 입력 값을 저장. Scanner scn(변수이름)
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine();// 사용자가 값을 입력하고 엔터를 치는 시점에 입력한 값을 읽고 반환하겠다.(입력한 다음줄에 보여줌)

		String[] names = { "김현지", "김유리", "남미주", "송지은" };
		// 사용자가 입력한 name 값이랑 배열안의 names 값이랑 비교해서 같을 경우 '그 값이 배열의 몇번째 입니다.'를 출력
		boolean isChecked = false;
		for (int i = 0; i < names.length; i++) {
			// "몇번째 위치에 있습니다." 출력
			if (names[i].equals(name)) { // 문자열 비교 메소드 문자열.equals(비교문자열)
				System.out.println((i + 1) + "번째에 있습니다.");
				isChecked = true;
				break;
			}
		}
		if (!isChecked) {
			System.out.println("찾는 이름이 없습니다.");
		}
		scn.close();
//
//		for (int j = 0; j < 1; j++) {
//			if (names[j].equals(name)) {
//				break;
//			} else {
//				System.out.println("입력한 이름이 해당 배열에 없습니다.");
//			}

		System.out.println("입력값 : " + name);

	}

}
