package SwimmingManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimDAO2 extends DAO { //데이터베이스에 접근해서 여러가지 작업
	
	// 입력
	public Swim insertSwim(Swim vo) { //매개값으로 입력받았던 EmployeeVO에다가 시퀀스값을 받아서 리턴하겠습니다.
		getConnect();
		
		String seq = "select user_sequ.nextval from dual"; //새로운 시퀀스값을 가져올 쿼리.
		
		
		String sql = "insert into empl (user_seq, user_name, user_age, user_phone, course, creation_date) "
				+ "values(?,?,?,?,?,?)";
		
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
			psmt.setString(2, vo.getUserName());
			psmt.setString(3, vo.getUserAge());
			psmt.setString(4, vo.getPhoneNum());
			psmt.setString(5, vo.getCourse());
			psmt.setString(6, vo.getcDate());
			int r = psmt.executeUpdate(); //쿼리를 실행해서 처리된 건수를 반환 (인트타입)
			System.out.println(r + "건 입력됨.");
			
			// 새롭게 입력하게된 사원번호를 알고싶을때.
			vo.setUserSeq(seqInt);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}
	// 삭제
	public void deleteSwim(int userSeq) {
		getConnect(); //커넥션 객체로 오는? 메소드
		String sql = "delete from userInfo where user_seq = ?"; //eid를 기준으로 한건 삭제
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userSeq);
			int r = psmt.executeUpdate(); //쿼리 실행
			System.out.println(r + "건 삭제됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	// 수정
	public void updateSwim(Swim vo) {
		getConnect();
		String sql = "update userInfo set user_name =?, user_age =?, user_phone=?, course=?, creation_date =? where user_seq= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserName());
			psmt.setString(2, vo.getUserAge());
			psmt.setString(3, vo.getPhoneNum());
			psmt.setString(4, vo.getCourse());
			psmt.setString(5, vo.getcDate());
			psmt.setInt(6, vo.getUserSeq());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//목록
	public List<Swim> swimList(Swim vo) {
		List<Swim> swimList = new ArrayList<Swim>();
		getConnect();
		String sql = "select * from userInfo"//
				+"    where user_seq = decode(?, 0, user_seq, ?)" // 
				+"    and   user_name like '%'||?||'%' "//
				+"    and   user_age like '%'||?||'%' "//
				+"    and   user_phone like '%'||?||'%' "//
				+"    and   course = nvl(?, course) "//
				+"    and   to_char(creation_date, 'yyyy-mm-dd') like '%'||?||'%'" //들어오는 값이 null이면 job_id 값 자체를 비교하겠습니다.
				+ " order by user_seq";
		
		try {
			psmt = conn.prepareStatement(sql); //조회된 결과값을 List<EmployeeVO>형태로 바꾸겠습니다.
			psmt.setInt(1, vo.getUserSeq());
			psmt.setInt(2, vo.getUserSeq());
			psmt.setString(3, vo.getUserName());
			psmt.setString(4, vo.getUserAge());
			psmt.setString(5, vo.getPhoneNum());
			psmt.setString(6, vo.getcDate());
			psmt.setString(7, vo.getCourse());
			
			
			rs = psmt.executeQuery(); //여러건 담을수있음
			while(rs.next()) {
				int userSeq = rs.getInt("user_seq");
				String userName = rs.getString("user_name");
				String userAge = rs.getString("user_age");
				String phoneNum = rs.getString("user_phone");
				String course =rs.getString("course");
				String cDate = rs.getString("creation_date");
				
				Swim swim = new Swim(userSeq, userName, userAge, phoneNum, course, cDate);
				swimList.add(swim);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return swimList;
	}
	
	
	

}
