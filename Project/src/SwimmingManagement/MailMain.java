package SwimmingManagement;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MailMain {
	
	MailApp app = new MailApp();

	public MailMain() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("메일을 입력하세요");
		String mail = scn.nextLine();
		
		String from = mail;
		String to = "rnjsalgus211";
		String subject = "인증메일입니다.";
		
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

		String content = resultNum; 
				
		if(app.sendMail(from, to, subject, content).equals("Success")) {
			System.out.println("성공!");

		}else {
			//콘솔에 "실패"; 
			System.out.println("실패!");
		}
	
}
		public static void main(String[] args) {
			new MailMain();
		}
	
}