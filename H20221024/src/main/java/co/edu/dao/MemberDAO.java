package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	
	
	
	//생성, 수정, 삭제, 한건조회, 목록조회..... 기능.
	
	public void memberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, name, email)\r\n"
				+ "values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 입력.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//한건 조회
	public MemberVO memberSearch(String id) {
		String sql = "select * from members where id = ? ";
		conn = getConnect();
		MemberVO member = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {

				member = new MemberVO(rs.getString("id")
						, rs.getString("passwd")
						, rs.getString("name")
						, rs.getString("email")
						);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	
	//수정
	public void memberUpdate(MemberVO vo) {
		String sql = "update members " + "set passwd = ?, " + "name = ?, " + "email =? " +  "where id = ?";
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
	
	//삭제
	public boolean memberDelete(String id) {
		String sql = "delete from members where id = ? ";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	//목록조회
	public List<MemberVO> memberList(){
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from members");
			while(rs.next()) {
				memberList.add(new MemberVO(rs.getString("id")//
						, rs.getString("passwd")
						, rs.getString("name")
						, rs.getString("email")
						));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return memberList;
	}
	
}
