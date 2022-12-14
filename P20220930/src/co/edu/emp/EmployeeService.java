package co.edu.emp;

//CRUD 처리. (기능만) ----추상메소드
public interface EmployeeService {
	//초기화(init)
	public void init();
	//추가
	public void input();
	public String search(int employeeId); //아이디 넣으면 이름을 리턴해주는 메소드 (정의)
	public void print(); //전체 사원정보 출력
	public int searchSal(int employeeId); //사원 아이디에 해당하는 급여정보 반환
}
