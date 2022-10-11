package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {

	public static void main(String[] args) {
		read();
	}

	public static void read() {

		try {
			FileReader reader = new FileReader("src/co/edu/io/ByteStreamExample.java");// FileWirter에서 입력한 것 읽어오기

			while (true) {
				int bytes = reader.read(); // reader가 리턴해주는 값은 int타입 2byte씩 읽어들임(문자기반이기때문에)
				if (bytes == -1) {
					break;
				}
				System.out.print((char)bytes); // 정수타입을 char타입으로 바꿔서 출력하기 : (char)bytes;
			}
			reader.close();
			System.out.println("completed.");

			// 발생할 수 있는 예외가 FileNotFound, IO 일수 있다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void wirte() {
		Scanner scn = new Scanner(System.in);

		// 문자기반 스트림 생성. Reader/ Writer. 읽고 쓰기 가능

		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt"); // 출력 스트림

			while (true) {
				System.out.print(">> ");
				String temp = scn.nextLine(); // 한 라인씩 읽어들이겠습니다.
				if (temp.equals("quit")) // quit 값 들어오면 반복문 종료하겠습니다.
					break;

				fw.write(temp + "\n");
			}

			fw.close();
			scn.close(); // 스캐너로 리소스 반환??

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");
	}
}
