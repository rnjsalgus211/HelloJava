package co.edu.inherit.dbinterface;

public class CompanyApp {
	public static void main(String[] args) {
		//추가, 수정, 삭제, 조회 기능
//		MysqlDAO dao = new MysqlDAO();
//		dao.insert();
//		dao.update();
//		dao.search();
//		dao.delete();
		
//		OracleDAO dao = new OracleDAO();
//		dao.add();
//		dao.modify();
//		dao.find();
//		dao.remove();
//		
		//인터페이스를 사용하지 않아서 똑같은 기능을 구현하지만 이름이 다 달라짐
		
		DaoService dao = new MysqlDAO();// ver1.0
		dao = new OracleDAO(); //ver2.0
		dao.insert();
		dao.modify();
		dao.remove();
		dao.search();
		
		
		//익명구현객체: 클래스 이름 선언할 필요없이 기능만 정의하고싶을때 
		//인터페이스 구현 코드만 작성.
		DaoService anonym = new DaoService() {

			@Override
			public void insert() {
				System.out.println("익명db 입력");
			}

			@Override
			public void modify() {
				System.out.println("익명db 수정");
			}

			@Override
			public void remove() {
				System.out.println("익명db 삭제");
			}

			@Override
			public void search() {
				System.out.println("익명db 조회");
			}
			
		};
		anonym.insert();
		anonym.modify();
		anonym.remove();
		anonym.search();
	}
}

//인터페이스 -> 배열저장, 컬렉션 저장
//사원 정보 저장 -> Employee 클래스
//EmployeeService 인터페이스.
//EmployeeArray 클래스(배열저장)
//EmployeeArrayList 클래스 (컬렉션저장).
//EmployeeApp 클래스(메인메소드)















