package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {

		long gameStart = System.currentTimeMillis();
		Scanner scn = new Scanner(System.in);
		String target = "Better a diamond with a flaw than a pebble without.";
		System.out.println(target);
		String[] targetAry = target.split(" ");
		
		boolean run = false;
		while (true) {
			System.out.println("입력 >>  ");
			String word = scn.nextLine();
			for (int i = 0; i < targetAry.length; i++) {
				if (targetAry[i] != null && targetAry[i].equals(word)) {
					targetAry[i] = null;
				}
			}
			run = true;
			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					run = false;
				}
				}
			long gameEnd = System.currentTimeMillis();
			long during = (gameEnd - gameStart)/1000; // 1*60*1000 + 30 * 1000 = 63000/60000분, 63000%6000초
			
			if(during>=20) {
				System.out.println("---------"+ during+ "초");
				System.out.println("시간초과입니다. GAME OVER!!!!!");
				run=true;
			}
			if (run) {
				System.out.println("---------"+ during+ "초");
				break;
			}

		}

	}
}
