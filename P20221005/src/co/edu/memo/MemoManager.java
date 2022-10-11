package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//조회 입력 삭제 기능 넣을것
public class MemoManager {

	List<Memo> memoStorage = new ArrayList<>(); // 임시로 정보를 담아놓기 위한 컬렉션
	File file = new File("c:/Temp/memoBook.dat");// 읽기 쓰기 모두 가능한 용도로
	Scanner scn = new Scanner(System.in);

	// 싱글톤
	private static MemoManager instance = new MemoManager();

	private MemoManager() {
		readFromFile(); //
	}

	public static MemoManager getInstance() {
		return instance;
	}

	// 추가.
	public void inputDate() {
		System.out.print("번호> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜> ");
		String date = scn.nextLine();
		System.out.print("내용> ");
		String cont = scn.nextLine();

		memoStorage.add(new Memo(no, date, cont));

	}

	// 조회. 날짜 입력시 해당되는 날짜에 대한 메모를 모두 출력
	public void searchDate() {
		System.out.print("날짜> ");
		String sDate = scn.nextLine();

		boolean exists = false;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (sDate.equals(memoStorage.get(i).getDate())) { // 메모라는 인스턴스 하나 리턴해주는것
				System.out.println(memoStorage.get(i).toString());
				exists = true;
			}
		}

		if (!exists) {
			System.out.println("해당날짜의 메모가 없습니다.");
		}
	}

	// 번호를 입력하면 한건 삭제.
	public void deleteDate() {
		System.out.println("삭제할 메모 번호를 입력하세요.");
		int no = Integer.parseInt(scn.nextLine());
			for (int i = 0; i < memoStorage.size(); i++) {
				if (memoStorage.get(i).getNo() == no) {
					memoStorage.remove(i);
					System.out.println("메모가 삭제되었습니다.");
				}else {
					System.out.println("찾는 번호가 없습니다.");
				}

				}
				if (memoStorage.isEmpty()) {
					System.out.println("모든 메모 삭제 완료");
				}
			
		}
	

	// 파일을 읽어서 데이터 memoStorage가능.
	public void readFromFile() {
		// try with resource. //close기능 구현하지 않아도 됨
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {

			memoStorage = (List<Memo>) ois.readObject();

		} catch (Exception e) {
//			e.printStackTrace();
			return;

		}

	}

	// 종료하면 파일ㅈ ㅓ장
	public void storeToFile() {
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(memoStorage); // 파일저장

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
