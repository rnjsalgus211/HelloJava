package co.gui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO { //데이터베이스에 접근해서 여러가지 작업
	
	// 입력
	public void insertEmp(EmployeeVO vo) {
		getConnect();
		String sql = "insert into empl (employee_id, frist_name, last_name, email, hire_date, job_id) "
				+ "values(employees_seq.nextval, ?,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFristName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			int r = psmt.executeUpdate(); //쿼리를 실행해서 처리된 건수를 반환 (인트타입)
			System.out.println(r + "건 입력됨.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect(); //커넥션 객체로 오는? 메소드
		String sql = "delete from empl where employee_id = ?"; //eid를 기준으로 한건 삭제
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			int r = psmt.executeUpdate(); //쿼리 실행
			System.out.println(r + "건 삭제됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update empl set first_name =?, last_name =?, emial=?, hire_date=?, job_id =? where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFristName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//목록
	public List<EmployeeVO> empList(EmployeeVO vo) {
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl"//
				+"    where employee_id = decode(?, 0, employee_id, ?)" // 
				+"    and   first_name like '%'||?||'%' "//
				+"    and   last_name like '%'||?||'%' "//
				+"    and   email like '%'||?||'%' "//
				+"    and   to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' "//
				+"    and   job_id = nvl(?, job_id)" //들어오는 값이 null이면 job_id 값 자체를 비교하겠습니다.
				+ " order by employee_id";
		
		try {
			psmt = conn.prepareStatement(sql); //조회된 결과값을 List<EmployeeVO>형태로 바꾸겠습니다.
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFristName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			
			
			rs = psmt.executeQuery(); //여러건 담을수있음
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String email = rs.getString("email");
				String hDate =rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				
				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return empList;
	}
	
	
	

}
