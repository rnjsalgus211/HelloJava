package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
   public static void main(String[] args) throws Exception { //main메소드 내에서 일어나는 모든 예외를 던지겠다.
	   
	   //C:/Temp/emp.dat를 읽어들이는 기능 만들기
	   FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
	   ObjectInputStream ois = new ObjectInputStream(fis);
	   ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject(); //ois가 오브젝트 타입이기때문에 ArrayList타입으로 형변환
	   
	   Scanner scn = new Scanner(System.in);
	   while(true) {
		   System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
		   System.out.print("선택>> ");
		   
		   int menu = scn.nextInt();
		   scn.nextLine();
		   
		   if(menu ==1) {
			      //empList에 add하기 (입력된것)
//			   System.out.print("사원번호>> ");
//			   int id = scn.nextInt();
//			   scn.nextLine();
//			   System.out.print("이름>> ");
//			   String name = scn.nextLine();
//			   System.out.print("부서>> ");
//			   String dept = scn.nextLine();
//			   System.out.println();
			   System.out.println("입력>> ex)100 홍길동 인사");
			   String empVal = scn.nextLine();
			   //split을 이용할 경우.
			   String[] empAry = empVal.split(" ");
			   Emp emp = new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]);
			   empList.add(emp);
			   System.out.println("입력완료");

//			   empList.add(new Emp(id, name, dept));
//			   System.out.println("사원정보가 등록되었습니다.");
			   
		   }else if (menu==2) {
			   FileInputStream fis1 = new FileInputStream("C:/Temp/emp.dat");
			   ObjectInputStream oos1 = new ObjectInputStream(fis1);
			   
			   for(Emp emp : empList) {
				   System.out.println(emp.toString());
			   }
		   }else if(menu==3) {
			   //사원번호를 기준으로 삭제. 
			   //내가 입력한 부서번호와 같은 부서번호가 입력되어있는 인덱스를 찾아서 삭제.
			   System.out.println("삭제할 사원의 번호를 입력하세요.");
			   int id = Integer.parseInt(scn.nextLine());
			   for(int i=0; i<empList.size(); i++) {
				   if(id==empList.indexOf(id)) {
					   empList.remove(empList.indexOf(id));
					   System.out.println("삭제가 완료되었습니다.");
				   }
			   }
		   }
		   
		   else if (menu==4) {
			   System.out.println("프로그램을 종료합니다.");
			   FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(empList);
			   break;
		   }else {
			   System.out.println("잘못된 메뉴를 선택했습니다.");
			   break;
		   }
	   }//end of while();
	   
}
}
