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
				System.out.print(str);

				str = str.replace(" ", "");
				str = str.replace("-", "");
				char charValue = str.charAt(6);

				switch (charValue) {
				case '1':
				case '3':
					System.out.println(" >> 남자입니다");
					break;
				case '2':
				case '4':
					System.out.println(" >> 여자입니다");
					break;
				default:
					System.out.println("잘못된 값을 입력하였습니다.");
					break;
				}

				// 교수님 방법
//			if (str.replace("-","").charAt(6)%2==1){
//				System.out.println("남자입니다.");   
//			}else if (str.replace("-","").charAt(6)%2==0){
//				System.out.println("여자입니다.");
//
//			}else if () {//년도, 월, 일 잘못되면 잘못된 번호라고 인식하게
//			}

//			if(str.indexOf(searchKey)!= -1) {
//			System.out.println(str);
//			}else {
////				System.out.println("");
//			}
			}
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}

		System.out.println("end of prog");
	}
}
