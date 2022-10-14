package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Morning20221014 {
	public static void main(String[] args) throws Exception {

//		FileInputStream fis = new FileInputStream("c:/Temp/memberList.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Member> memList = new ArrayList<>();

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.회원등록 2.목록 3.삭제 4.종료");
			
				System.out.println("선택>>  ");
				int menu = scn.nextInt();
				scn.nextLine();

				if (menu == 1) {
					System.out.println("입력>> ex) user 김서방 1000");
					String memVal = scn.nextLine();
					String[] memAry = memVal.split(" ");
					Member mem = new Member(memAry[0], memAry[1], Integer.parseInt(memAry[2]));

					memList.add(mem);
					System.out.println("입력완료");
					
					try (FileWriter fw = new FileWriter("c:/Temp/memberList.txt");) {
						for (Member mem2 : memList) {
							fw.write(mem2.getUserId() +"\t"+ mem2.getUserName() +"\t"+ mem2.getUserPoint()+"\n");
						}

					} catch (Exception e) {
						e.printStackTrace();
					
					}
					if (memVal.equals("quit")) {
						System.out.println("프로그램을 종료합니다.");
						break;
					}

				}

				if (menu == 2) {
					try {
						FileReader reader = new FileReader("c:/Temp/memberList.txt");

						while (true) {
							int bytes = reader.read();
							if (bytes == -1) {
								break;
							}
							System.out.print((char) bytes);
							
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println();
				}
		}
		

	}

	// writer 스트림(파일에 입력)
	public static void write() {
		Scanner scn = new Scanner(System.in);

		try {
			FileWriter fw = new FileWriter("c:/Temp/memberList.txt");

			while (true) {
				System.out.println(">> ");
				String temp = scn.nextLine();
				if (temp.equals("quit"))
					break;

				fw.write(temp + "\n");
			}

			fw.close();
			scn.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");

	}

	// read 스트림 (출력)

//	public static void read() {
//
//		try {
//			FileReader reader = new FileReader("c:/Temp/memberList.txt");
//
//			while (true) {
//				int bytes = reader.read();
//				if (bytes == -1) {
//					break;
//				}
//				System.out.print((char) bytes);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}