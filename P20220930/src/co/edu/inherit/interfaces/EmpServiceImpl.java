package co.edu.inherit.interfaces;


//구현 클래스(인터페이스를 상속하는 클래스)
public class EmpServiceImpl implements DaoService {//인터페이스를 구현하는 클래스는들은 implements 사용해서 구현
	//클래스기 때문에 필드 정의 가능
	private String db;
	
	public EmpServiceImpl() {}
	public EmpServiceImpl(String db) {
	this.db = db;
	}
	
	public void setDb(String db) {
		this.db =db;
	}
	public String getDb() {
		return this.db;
	}
		
	@Override
	public void insert() {
		System.out.println(db + " 저장.");
	}

	@Override
	public void search() {
		System.out.println(db + " 조회.");
	}

	@Override
	public void delete() {
		System.out.println(db + " 삭제.");
		
	} 

}
