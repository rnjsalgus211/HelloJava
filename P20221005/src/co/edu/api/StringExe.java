package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {

		String fileName = "src/co/edu/api/birth.txt";
		File file = new File(fileName);

		String searchKey = "자 바";
		searchKey = searchKey.replace(" ", ""); // replace("바꿀문자열", "바꿀내용)

		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null)
					break;
				String firstNum = str.substring(2,4);
				int num1 = Integer.parseInt(firstNum);
				String firstNum2 = str.substring(4,6);
				int num2 = Integer.parseInt(firstNum2);
					
			if (num1>12) {//년도, 월, 일 잘못되면 잘못된 번호라고 인식하게 	
				System.out.println("월 값을 확인하세요.");
			}else if (num2>31) {
				System.out.println("날짜를 확인하세요.");
			}
				System.out.print(str);

				// 교수님 방법
			if (str.replace("-","").charAt(6)%2==1){
				System.out.println("남자입니다.");   
			}else if (str.replace("-","").charAt(6)%2==0){
				System.out.println("여자입니다.");
			}

			if(str.indexOf(searchKey)!= -1) {
			System.out.println(str);
			}else {
				System.out.println("");
			}
			}
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}

		System.out.println("end of prog");
	}
}


//str = str.replace(" ", "");
//str = str.replace("-", "");
//char charValue = str.charAt(6);
//
//switch (charValue) {
//case '1':
//case '3':
//	System.out.println(" >> 남자입니다");
//	break;
//case '2':
//case '4':
//	System.out.println(" >> 여자입니다");
//	break;
//default:
//	System.out.println("잘못된 값을 입력하였습니다.");
//	break;
//}