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
		while(true) {
		try {
			int bytes = System.in.read();
			if (bytes ==123)
				break;
			if(97<=bytes && bytes>=122) {
				bytes = bytes - 32;
				System.out.println(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
}

//교수님 답안 (소문자->대문자, 대문자->소문자)
//String[] msgAry = msg.split("");
//byte[] bytes = new byte[msg.length()];
//int i =0;
// for (string str : asgAry){
//char chr = str.charAt(0);
// int chr2 = 0;

//if (chr>=97)
// chr2 =chr - 32;
//esle if (chr<=92)
// chr2 = chr+32;