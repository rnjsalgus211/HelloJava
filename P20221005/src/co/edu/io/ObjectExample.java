package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// Serializable자체로는 아무 기능X
// Serializable를 구현하는 클래스라는것을 선언해줘야지 objectOutputStream을 사용할수있음.
class Emp implements Serializable { // Emp 클래스를 스트림에 저장하고 불러오는 작업 해보기
	
	int id;
	String name;
	String dept;

	public Emp(int id, String name, String dept) { // 매개값 3개있는 생성자
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "사원id: " + id + ", 이름: " +name+ ", 부서: " + dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}

public class ObjectExample {
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
		// 입출력 스트림 ->Class로 인스턴스 생성 -> 파일입출력으로 저장.
		// ObjectInputStream, ObjectOutputStream: Object(오브젝트) 기반으로 쉽게 처리를 해주는 스트림클래스
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "홍길동", "인사"));
		empList.add(new Emp(200, "김민식", "총무"));
		empList.add(new Emp(300, "이유진", "개발"));

		try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);// 보조스트림(기능을 가지고있음)
		// =>이렇게 작성했을 때 oos.close();/ fos.close(); 작성해줄 필요 X
		) {
			oos.writeObject(empList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed!");
		
}
}
