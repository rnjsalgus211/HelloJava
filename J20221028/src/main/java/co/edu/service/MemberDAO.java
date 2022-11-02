package co.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.common.DAO;
import co.edu.member.MemberVO;

public class MemberDAO extends DAO {
	
	//스케줄 입력 메소드
	public void insertCalendar(MemberVO vo){
		getConnect();
		String sql = "insert into full_calendar (title, start_date, end_date) "
				     + " values (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getSDate());
			psmt.setString(3, vo.getEDate());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	// 전체 스케줄 목록 가져오는 메소드.
	public List<MemberVO> calendarInfo() {
		getConnect();
		String sql = "select * from full_calendar";
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				MemberVO vo = new MemberVO();
				vo.setTitle(rs.getString("title"));
				vo.setSDate(rs.getString("start_date"));
				vo.setEDate(rs.getString("end_date"));
		
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	//부서명, 부서인원 가지고 오는 메소드
	public Map<String, Integer> getEmpByDept(){
		getConnect();
		Map<String, Integer> map = new HashMap<>(); //키,밸류 형식으로 데이터를 담을 수 있다. 
		String sql = "select d.department_name, count(1)\r\n"
				+ "from hr.employees e\r\n"
				+ "join hr.departments d\r\n"
				+ "on e.department_id = d.department_id\r\n"
				+ "group by d.department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return map;
	}
	
	//한건삭제
	public boolean deleterMember(String id) {
		getConnect();
		String sql = "delete from members where id =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
		
	}
		
	//한건등록
	public void insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, email, name, responsibility) "//
					+ " values(?, ?, ?, ?, 'user') ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getName());
			
			psmt.executeUpdate();
			
			vo.setRespons("user");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}
	
	// 전체목록 가지고오는 메소드.
	public List<MemberVO> memberList() {
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()){
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRespons(rs.getString("responsibility"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
