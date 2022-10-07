package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Employe {
	int empId;
	String name;
	int salary;

	public Employe(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	// 동일한 객체: hashCode랑 equlas값을 비교
	@Override
	public int hashCode() { // 사원번호가 같으면 동일한 논리적인 객체로 보겠습니다.
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employe) {// obj가 Employee의 인스턴스가 맞으면
			Employe target = (Employe) obj;// casting
			return (this.empId == target.empId //
					&& this.name.equals(target.name)//
					&& this.salary == target.salary);
		} else {
			return false;
		}

	}
}

// 이것이 자바다 734p
public class SetExample {
	public static void main(String[] args) {
		// Set은 인덱스 값 상관 XXXXXXXXXX
		Set<Employe> employees = new HashSet<Employe>(); // Set컬렉션에는 Employee클래스의 정보만 담겠습니다.
		employees.add(new Employe(100, "권미현", 3000));
		employees.add(new Employe(200, "홍길동", 2500));
		employees.add(new Employe(300, "최윤기", 2000));
		employees.add(new Employe(100, "김길동", 3000));

		employees.remove(new Employe(100, "김길동", 3000)); // 사원 번호만 같으면 중복값으로 인식하게 만들었기 때문에 뒤의 정보는 상관없이 사번만 같으면 삭제됨
		System.out.println(employees.size());

		// 반복자를 통해서 요소를 하나씩 호출
		Iterator<Employe> iter = employees.iterator();
		while (iter.hasNext()) {
			Employe emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d \n", emp.empId, emp.name, emp.salary);
		}

		Set<Integer> set = new HashSet<Integer>();

		// 중복 허용X set 컬렉션 사용하기. (구슬주머니에 구슬 넣기)
		while (set.size() < 7) {
			set.add((int) (Math.random() * 45) + 1);
		}
		for (int n : set) {
			System.out.println(n);
		}
		// 중복저장 불가.
//			int[] lotto = new int [7];
//			
//			for(int i=0; i<lotto.length; i++) {
//				int temp = (int)(Math.random()* 7)+1;
//				//현재 인덱스 값보다 적은 위치에 temp와 같은 값이 있는지 체크
//				boolean exists =false;
//				for(int j=0; j<i; j++) {
//					//같은 값이 있으면.. 다시 돌리기
//					if(lotto[j]==temp) {
//						i--;
//						exists = true;
//					}
//					
//				}//다음 구문 실행하지 않고 포구문으로 돌아가서 다시 실행
//				if(exists)
//					continue;
//				
//				lotto[i] =temp;
//				
//			}
//			for(int n : lotto) {
//				System.out.printf("%d ", n); //동일한 값이 출력될수있음.
//			}

	}
}
