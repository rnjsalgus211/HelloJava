package co.edu.emp;

//데이터처리 클래스(사원 정보 저장)
public class Employee {
	//사원번호, 사원이름, 부서번호, 부서명, 급여, 이메일
	private int employeeId;
	private String name;
	private int deptId; //부서번호 - 10번:인사팀, 20:개발팀, 30:영업팀 (기본값)
	private String deptName;
	private int salary;
	private String email;
	
	//생성자 정의 -public 클래스명(){} 기본생성자
	public Employee() {
		this.deptId = 30;
		this.deptName = "영업";
	}
	
	
	//매개값 4개 있는 생성자
	public Employee(int employeeId, String name, int salary, int deptId) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
		if(this.deptId == 10) {
			this.deptName = "인사";
		}else if (this.deptId == 20) {
			this.deptName = "개발";
		}else {
			this.deptName ="영업";
		}
		
	}
	//매개값 3개 생성자
	public Employee(int employeeId, String name, int salary) {
		this(employeeId, name, salary, 30); //바로 위의 매개값이 4개인 Employee를 호출하고있음. 30을 기본값으로 설정
		
	}
	
	//매개값 2개 생성자
	public Employee(int employeeId, String name) {
		this(employeeId, name, 0); //사번과 이름만 넣어주었을 때는 급여 기본값을 0원으로 초기화. 부서는 30번으로 설정됨 (위의 매개값3개인 Employee를 호출하기 때문)
	}
	
	//5개 있는 생성자
	public Employee(int employeeId, String name, int salary, int deptId, String email) {
		this(employeeId, name, salary, deptId);
		this.email = email;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) { //부서명은 부서 번호에 종속되어서 정해지기때문에 바로 설정해주기
		this.deptId = deptId;
		if(this.deptId == 10) {
			this.deptName = "인사";
		}else if (this.deptId == 20) {
			this.deptName = "개발";
		}else {
			this.deptName ="영업";
		}
	}
	public String getDeptName() {
		return deptName;
	}
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;	
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}////////////////////////////











