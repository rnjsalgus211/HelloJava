package co.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class employee {
	int empId;
	String empName;
	int salary;

	public employee(int empId, String empName, int salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "사번: " + this.empId + ", 이름: " + this.empName + ", 급여: "+ this.salary;
	}
}

public class MorningCode {
	public static void main(String[] args) {
//		String tok = "Hello World Good";
//		Scanner scn = new Scanner(tok);
		Scanner scn = new Scanner(System.in); // 키보드 입력으로 들어온 값은 얘가 읽도록?

		ArrayList<employee> list = new ArrayList<employee>();
		System.out.println("입력>> ex) 100 홍길동 2500");
		while (true) {
			String inputVal = scn.nextLine();
			String[] frd = inputVal.split(" ");// ( )안의 문자열 만났을 때 잘라주기		
			if (frd[0].equals("quit")) {//quit 넣으면 종료
				break;
			}
			
			if(frd.length != 3) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			
			list.add(new employee(Integer.parseInt(frd[0]), frd[1], Integer.parseInt(frd[2])));
		}
		for (employee frd : list) {
			System.out.println(frd);
		}
		System.out.println("end of prog.");
	}

}

// 첫번째 값=> empId, 두번째 값=> empName, 세번째 값 =>salary
// Employee클래스의 인스턴스 생성.
// ArrayList 에 저장.
// 종료를 하고 싶으면 quit =>종료

// for(반복문) 출력.
//
////while(scn.hasNext())
////System.out.println(scn.next());
//
//String[] toks = tok.split(" ");
//for(String str : toks) {
//System.out.println(str);