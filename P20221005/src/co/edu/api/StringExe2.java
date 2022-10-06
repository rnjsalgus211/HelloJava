package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF");
		while(true) {
			try {
				int bytes = System.in.read();
				if (bytes ==122)
					break;
				
				System.out.println("입력값: " + bytes); //아스키 코드 값 나옴 65~90 A-Z대문자 97~122 a-z
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");
	}


	
	public static void changeCapital(String msg) {
		//대문자->소문자, 소문자->대문자
		//aBcD -> AbCd 97(a):65(A) ~ 122(z): 90(Z) 소문자 - 32하면 대문자 / 대문자 +32 소문자값이 나옴
		//소문자 97~122, 대문자 65~90
		
	}
}