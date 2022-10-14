package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
	String userId;
	String userName;
	int userPoint;

	public Member(String userId, String userName, int userPoint) {
		this.userId = userId;
		this.userName = userName;
		this.userPoint = userPoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

public static class ObjectExample2{
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
				ObjectInputStream oos = new ObjectInputStream(fis);  //선언과 close 한꺼번에 할 수 있도록
			){
				ArrayList<Emp> list = (ArrayList<Emp>) oos.readObject();
				
				for(Emp emp : list) {
					System.out.println(emp.toString());
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void writeObj() {
		ArrayList<Member> memList = new ArrayList<>();
		memList.add(new Member("user1", "홍길동", 3000));
		memList.add(new Member("nice11", "김경미", 3500));
		memList.add(new Member("gold01", "권우수", 5000));

		try (FileOutputStream fos = new FileOutputStream("c:/Temp/memberList.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

		) {
			oos.writeObject(memList);
		}catch ( FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e ) {
			e.printStackTrace();
		}
		System.out.println("completed!!");
	}
}
}
