package co.edu.inherit.dbinterface;

public class OracleDAO implements DaoService{
	@Override
	public void insert() {
		System.out.println("orcal 저장");
	}
	@Override
	public void modify() {
	System.out.println("orcal 수정");
	}
	@Override
	public void remove() {
		System.out.println("orcal 삭제");
	}
	@Override
	public void search() {
		System.out.println("orcal 조회");
	}
	//추가, 수정, 삭제, 조회
	
//	public void add() {
//		System.out.println("Oracle 저장");
//	}
//	public void modify() {
//		System.out.println("Oracle 수정");
//	}
//	public void find() {
//		System.out.println("Oracle 조회");
//	}
//	public void remove() {
//		System.out.println("Oracle 삭제");
//		
//	}
	
	
}
