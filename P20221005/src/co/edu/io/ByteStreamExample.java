package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {
	public static void main(String[] args) {
		try {
			fileCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//byte 단위로 읽고 쓰기 작업.
	public static void fileCopy() throws IOException {
		FileInputStream fis = new FileInputStream("C:/Temp/origin.jpg");
		FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg"); //출력할때
		byte[] buf = new byte[100];
		
		
		//시간출력
		long start = System.currentTimeMillis();
		
		while(true) {
			int bytes = fis.read(buf); //한바이트씩 읽기
			if(bytes == -1)
				break;
			
			fos.write(buf);//배열의 크기만큼 buf에 모아뒀다가 한번에 저장?
			
		}
		fos.close();
		fis.close();
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("complete.");
	}
	
	
	public static void readBuf() throws IOException {
		InputStream is = new FileInputStream("C:/Temp/data2.dat");
		byte[] buf = new byte[2]; //buf의 크기만큼 읽어들이겠다. 
		
		while(true) {
			int bytes = is.read(buf); // 배열에 선언된 크기 만큼 읽어들임. 읽어들일값X -1리턴
			if(bytes == -1) {
				break;
			}
			
			for(int i=0; i<bytes; i ++) {
				System.out.print(buf[i] + " " );
			}
			System.out.println();
			
		}
		System.out.println("complete.");
		is.close();
		
	}

	public static void writeBuf() throws IOException { // 예외 발생시 wirteBuf를 호출한 영역에서 예외처리를 해주는것
		byte[] arr = new byte[] { 10, 20, 30 }; // 바이트 배열 선언
		OutputStream os = new FileOutputStream("C:/Temp/data2.dat");
		os.write(arr);
		os.close();

		System.out.println("complete.");
	}

	public static void read() {

		try {
			InputStream is = new FileInputStream("C:/Temp/data1.dat"); // 읽어들이기위한 인풋스트림(입력스트림) 생성.

			while (true) {
				int bytes = is.read(); // 한 바이트씩 읽어들이겠다 >read메소드.
				if (bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}

			is.close(); // 스트림은 사용하고 난 뒤 종료해줘야함.

			// 더이상 읽어올 byte값이 없으면 -1을 반환
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete");
	}

	public static void wirte() {
		// 출력스트림(바이트)

		try {
			OutputStream os = new FileOutputStream("C:/Temp/data1.dat");
			byte a = 10;
			byte b = 20;

			os.write(a);
			os.write(b);

			// 사용이 끝이나면 리소스(resource)를 반환
			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("complete.");

	}
}
