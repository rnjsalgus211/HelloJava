package SwimmingManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Create Read Update Delete CRUD 기능 구현
public class SwimDAO extends DAO {

	//로그인 
	public int login(String id, String passwd) {
  
		String sql = "select * from users where id = ? and passwd = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);

			rs = psmt.executeQuery(); // 담겨져있는 값을 하나 읽어오겠습니다

			if (rs.next()) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}
	
	// 추가
	public void insert(Swim sw) {
		System.out.println(sw);
		String sql = "insert into userInfo (user_seq, user_name, user_age, user_phone, payment, course, creation_date)\r\n"
				+ "values(user_sequ.nextval, '" 
				+ sw.getUserName() + "', '" 
				+ sw.getUserAge() + "', '"
				+ sw.getPhoneNum() + "', '" 
				+ sw.getPayment() + "', '"
				+ sw.getCourse() + "', sysdate)";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 조회
	public List<Swim> search() {
		conn = getConnect();
		List<Swim> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from userInfo");
			while (rs.next()) {
				list.add(new Swim(rs.getInt("user_seq")//
						, rs.getString("user_name"), rs.getString("user_age")
						,rs.getString("course"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//상세조회
	public Swim getNum(int userSeq) {
		String sql = "select * from userInfo where user_seq= ?";
		conn = getConnect();
		Swim sw = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userSeq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				sw = new Swim(rs.getInt("user_seq")
							, rs.getString("user_name")
							,rs.getString("user_age")
							,rs.getString("user_phone")
							,rs.getInt("payment")
							,rs.getString("course")
							,rs.getString("creation_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return sw;
	}
	//강사조회
//	public List<Swim> tInfo(){
//		conn = getConnect();
//		List<Swim> list1 = new ArrayList<>();
//
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from teachers");
//			while (rs.next()) {
//				list1.add(new Swim(rs.getString("teacher_name")//
//						,rs.getString("teacher_sex"), rs.getString("teacher_uni")
//						,rs.getString("course")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list1;
//	}
	
	
	//수정
	public void update(Swim sw) {
		String sql = "update userInfo"
				+ " set user_name= ?, "
				+ "	   user_age = ?, "
				+ "    user_phone = ?, "	
				+ "    payment = ?, "
				+ "    course = ?, "
				+ "creation_date = ? "
				+ "where user_seq = ?";	
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sw.getUserName());
			psmt.setString(2, sw.getUserAge());
			psmt.setString(3, sw.getPhoneNum());
			psmt.setInt(4, sw.getPayment());
			psmt.setString(5, sw.getCourse());
			psmt.setString(6, sw.getcDate());
			psmt.setInt(7, sw.getUserSeq());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//삭제
	
	public boolean delete (int userSeq) {
		String sql = "delete from userInfo where user_seq = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userSeq);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	//강사 평가
	
}//end of Class();
