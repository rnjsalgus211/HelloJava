package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {

	// 생성, 수정, 삭제, 한건조회, 목록조회..... 기능.

	public void memberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, name, email)\r\n" + "values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 한건 조회
	public MemberVO memberSearch(String id) {
		String sql = "select * from members where id = ? ";
		conn = getConnect();
		MemberVO member = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {

				member = new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getString("email"), rs.getString("responsibility"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 수정
	public void memberUpdate(MemberVO vo) {
		String sql = "update members "//
					+ "set passwd = ?, "// 
					+ "name = ?, "// 
					+ "email =? "// 
					+ "where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 삭제
	public boolean memberDelete(String id) {
		String sql = "delete from members where id = ? ";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

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

	// 목록조회
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from members");
			while (rs.next()) {
				memberList.add(new MemberVO(rs.getString("id")//
						, rs.getString("passwd"), rs.getString("name"), rs.getString("email")
						, rs.getString("responsibility")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}

	// String id, String passwd 두개의 값을 넘길것임. => return은 MemberVO타입으로 리턴. (통으로 값을
	// 넘긴다.) 값이 있으면 vo라는 리소스가 하나 반환되고, 없으면 null값이 반환된다.
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id = ? and passwd = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id")); // id라는 칼럼에있는 값을 읽어와서 setId값에 넣어주겠습니다.
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return null;

	}

}
