package SwimmingManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Create Read Update Delete CRUD 기능 구현
public class SwimDAO extends DAO {

	// 회원가입
	public void membership(Login login) {
		String sql = "insert into users (id, passwd, user_name, user_email)"
				+ "values(" + " '" + login.getUserId()//
				+ "', '" + login.getPasswd()//
				+ "', '" + login.getUserName()//
				+ "', '" + login.getUserEmail() + "')";//
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
	
	//이메일
	public void email(String mail) {
		//?
		
	}
	
	// 회원탈퇴
	public boolean delMember(String userId) {
		String sql = "delete from users where id = ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
				
	}
	
	//회원 로그인정보 조회
	public Login getId(String userId) {
		String sql = "select * from users where id = ?";
		conn = getConnect();
		
		Login log = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				log = new Login(rs.getString("id"), rs.getString("passwd"),
						rs.getString("user_name"), rs.getString("user_email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return log;
	}
	//회원 로그인정보 조회2
	public Login getName(String userName) {
		String sql = "select * from users where user_name = ?";
		conn = getConnect();
		
		Login log = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);
			rs = psmt.executeQuery();
			if (rs.next()) {
				log = new Login(rs.getString("id"), rs.getString("passwd"),
						rs.getString("user_name"), rs.getString("user_email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return log;
	}

	
	// 로그인
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
		String sql = "insert into userInfo (user_seq, user_name, user_age, user_phone, course, creation_date)\r\n"
				+ "values(user_sequ.nextval, '" + sw.getUserName() + "', '" + sw.getUserAge() + "', '"
				+ sw.getPhoneNum() + "', '" + sw.getCourse() + "', sysdate)";
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

	// 회원전체조회
	public List<Swim> search() {
		conn = getConnect();
		List<Swim> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from userInfo order by user_seq");
			while (rs.next()) {
				list.add(new Swim(rs.getInt("user_seq")//
						, rs.getString("user_name"), rs.getString("user_age"), rs.getString("course"),
						rs.getString("creation_date")));
			}
		} catch (SQLException e) {
		} finally {
			disconnect();
		}
		return list;
	}

	// 회원상세조회
	public Swim getNum(int userSeq) {
		String sql = "select * from userInfo where user_seq= ?";
		conn = getConnect();
		Swim sw = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userSeq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				sw = new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_age"),
						rs.getString("user_phone"), rs.getString("course"), rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return sw;
	}
	
	//회원상세조회2
	public Swim getName2(String userName) {
		String sql = "select * from userInfo where user_name= ?";
		conn = getConnect();
		Swim sw1 = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);
			rs = psmt.executeQuery();
			if (rs.next()) {
				sw1 = new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_age"),
						rs.getString("user_phone"), rs.getString("course"), rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return sw1;
	}

	// 강사 조회
	public List<Teacher> teacherInfo() {
		conn = getConnect();
		List<Teacher> list1 = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from teachers");
			while (rs.next()) {
				list1.add(new Teacher(rs.getString("teacher_name")//
						, rs.getString("teacher_sex"), rs.getString("teacher_uni"), rs.getString("course")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list1;
	}

	// 강사 상세조회

	public Teacher getTeacher(String tName) {
		String sql = "select * from teachers where teacher_name = ?";
		conn = getConnect();
		Teacher tea = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tName);
			rs = psmt.executeQuery(); // 담겨져있는 값을 하나 읽어오겠습니다
			if (rs.next()) {
				tea = new Teacher(rs.getString("teacher_name")//
						, rs.getString("teacher_sex"), rs.getString("teacher_uni"), rs.getString("course"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return tea;
	}

	// 수정
	public void update(Swim sw) {
		String sql = "update userInfo" + " set user_name= ?, " + "	   user_age = ?, " + "    user_phone = ?, "
				+ "    course = ?, " + "creation_date = ? " + "where user_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sw.getUserName());
			psmt.setString(2, sw.getUserAge());
			psmt.setString(3, sw.getPhoneNum());
			psmt.setString(4, sw.getCourse());
			psmt.setString(5, sw.getcDate());
			psmt.setInt(6, sw.getUserSeq());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 삭제

	public boolean delete(int userSeq) {
		String sql = "delete from userInfo where user_seq = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userSeq);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 강사 평가
	// 강사평가 달기
	public void reply(Reply rep) {
		String sql = "insert into teacher_reply (rep_seq, course, teacher_name, rep_content, user_name)\r\n"
				+ "values(rep_sequ.nextval, " + "'" + rep.getCourse() + "', '" + rep.gettName() + "', '"
				+ rep.getContent() + "', '" + rep.getUserName() + "')";
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

	// 강사평 상세보기
	public Reply repDetail(int repNum) {
		String sql = "select * from teacher_reply where rep_seq = ? ";
		conn = getConnect();
		Reply reply = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, repNum);

			rs = psmt.executeQuery();
			while (rs.next()) {
				reply = new Reply(rs.getInt("rep_seq"), rs.getString("course")//
						, rs.getString("teacher_name"), rs.getString("rep_content"), rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return reply;
	}

	// 강사평 조회
	public List<Reply> repSearch(String tName) {
		String sql = "select * from teacher_reply where teacher_name = ? order by rep_seq ";
		conn = getConnect();
		List<Reply> rep = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tName);

			rs = psmt.executeQuery();
			while (rs.next()) {
				rep.add(new Reply(rs.getInt("rep_seq"), rs.getString("course")//
						, rs.getString("teacher_name"), rs.getString("rep_content"), rs.getString("user_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return rep;
	}

	// 강사평 삭제
	public boolean repDelete(int repNum) {
		String sql = "delete from teacher_reply where rep_seq = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, repNum);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
}// end of Class();