package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {
	
	public boolean delete(int empId) { //삭제할때는 Id값 하나만 알고있으면 되기때문에 매개값으로 empId만 줌.
		String sql = "delete from empl where employee_id = ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			
			int r = psmt.executeUpdate();//처리 된 건수를 반환(삭제된 건수가 있을 경우)
			if(r > 0) {
			return true; //메소드 안에서 리턴구문을 만나면 이 값을 반환해주고 프로그램을 끝내겠습니다. 라는 뜻
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false; //아무것도 처리 되지 않았음
	}
	
	
	public void update(Employee emp) { // ?는 나중에 값을 채워넣겠다는 의미
		String sql = "update empl "
				+ "set    last_name= ?, "
				+ "email = ?, "
				+ "       hire_date = ?, "
				+ "       job_id = ?"
				+ "where  employee_id = ?";
		conn = getConnect();
		try { //statement객체는  // psmt는 prepareStatement<<로
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			psmt.setInt(5, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void insert(Employee emp) {
		System.out.println(emp);
		String sql = "insert into empl (employee_id, last_name, email, hire_date, job_id)\r\n"  
				+"values("+ emp.getEmployeeId()//
				+ ", '" + emp.getLastName()//
				+ "', '" + emp.getEmail()//
				+ "', '" + emp.getHireDate()//
				+ "', '" + emp.getJobId() + "')";
//		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	// 조회.
	public List<Employee> search() {
		conn = getConnect(); // conn변수 값은 DAO 클래스가 가지고 있는 필드값이기 때문에 사용가능
		List<Employee> list = new ArrayList<>();// 반환 하기 위한 값
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl order by employee_id");
			while (rs.next()) {//next()의 역할 : 값을 순서대로 읽어옴.... 값이 없을 경우 false가 리턴되면서 반복문을 빠져나옴
				list.add(new Employee(rs.getInt("employee_id")//
						, rs.getString("last_name")//
						, rs.getString("email")//
						, rs.getString("hire_date")//
						, rs.getString("job_id") // 읽어들인 값들을 생성자 매개값으로 사용하겠다

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public Employee getEmp(int empId) {
		//한건만 반환.
		String sql = "select * from empl where employee_id = ?";
		conn = getConnect();
		Employee emp =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery(); //담겨져있는 값을 하나 읽어오겠습니다
			if (rs.next()) { 
				emp = new Employee(rs.getInt("employee_id")//
						, rs.getString("last_name")//
						, rs.getString("email")//
						, rs.getString("hire_date")//
						, rs.getString("job_id"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return emp;
	}
	

}
