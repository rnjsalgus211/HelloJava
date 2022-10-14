package co.edu.nested;

import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

public class FunctionalExample {
	public static void main(String[] args) {
		// Funtional interface.
		// 1.Consumer타입 :매개값은 있고 반환값은 없습니다.
		// accept메소드를 구현해주어야함. String t는 accept메소드의 매개값으로 사용되어짐

		Consumer<String> consumer = (String t) -> {
			System.out.println(t + "는 흥미롭습니다.");
		};
		consumer.accept("자바");

		// 함수적 프로그래밍 -> 데이터 처리.
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search(); // dao의 search메소드가 컬렉션타입으로 반환?

		// 데이터의 흐름 : stream.
		// stream의 각각의 값 > forEach구문 사용 consumer라는 익명구현객체를 매개값으로 사용.
		list.stream().forEach((t) -> System.out.println(t.toString())); 
		// 종료(;)는 foreach문 끝에다가 해주기. 매개값으로 Funtion(t)이 들어오기때문에.

	}
}
