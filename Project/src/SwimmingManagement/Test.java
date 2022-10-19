package SwimmingManagement;

import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		MailApp app = new MailApp();
//		Scanner scn = new Scanner(System.in);
		send();
	}
	public static void send() {
		MailApp app = new MailApp();
		Scanner scn = new Scanner(System.in);
		Random random = new Random();
		int createNum = 0; 
		String ranNum = ""; 
		int letter = 6; 
		String resultNum = "";

		for (int i = 0; i < letter; i++) {

			createNum = random.nextInt(9); 
			ranNum = Integer.toString(createNum);
			resultNum += ranNum; 
		}
		
		System.out.println("이메일을 입력하세요.");
		String mail =  scn.nextLine(); 
		
		String from = ""+mail+"";
		String to = "rnjsalgus211@naver.com";
		String subject = "대구수영장 회원 인증번호입니다.";
		String content = "인증번호는 " + resultNum + " 입니다. 확인 창에 입력해주세요." ; 
		app.sendMail(from, to, subject, content);
		
		boolean run = true;
		while(run) {
		System.out.println("인증번호>> (6자리) ");
		String num = scn.nextLine();
		if(num.equals(resultNum)) {
			System.out.println("인증번호가 확인되었습니다.");
			run = false;
		}else {
			System.out.println("인증번호가 틀렸습니다.");
			continue;
		}
		}
}
}
