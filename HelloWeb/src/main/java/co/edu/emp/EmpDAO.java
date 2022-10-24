package co.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO { //데이터베이스에 접근해서 여러가지 작업
	
	// 입력
	public EmployeeVO insertEmp(EmployeeVO vo) { //매개값으로 입력받았던 EmployeeVO에다가 시퀀스값을 받아서 리턴하겠습니다.
		getConnect();
		String seq = "select employees_seq.nextval from dual"; //새로운 시퀀스값을 가져올 쿼리.
		
		
		String sql = "insert into empl (employee_id, first_name, last_name, email, hire_date, job_id)\r\n "
				+ " values(?,?,?,?,?,?)";
		
		try {
			//시퀀스를 가져오기 위한 쿼리를 먼저 실행
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				seqInt = rs.getInt(1); //첫번째 칼럼을 가져오겠습니다.
				
			}
			//----------------------------------
			
			//insert 작업.
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt); 
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			int r = psmt.executeUpdate(); //쿼리를 실행해서 처리된 건수를 반환 (인트타입)
			System.out.println(r + "건 입력됨.");
			
			// 새롭게 입력하게된 사원번호를 알고싶을때.
			vo.setEmployeeId(seqInt);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
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
			psmt.setString(1, vo.getFirstName());
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
	//목록조회
	public List<EmployeeVO> empList(EmployeeVO vo) {
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl"//
				+"    where nvl(employee_id, 0) = decode(?, 0, nvl(employee_id, 0), ?)" // 
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
			psmt.setString(3, vo.getFirstName());
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
