package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Create Read Update Delete CRUD 기능 구현
public class BoardDAO extends DAO{
	//추가Create
	public void insert(Board brd) {
		System.out.println(brd);
		String sql = "insert into board (board_num, board_title, board_content, board_writer, creation_date, cnt)\r\n"
				+"values(" + brd.getbNum()//
				+", '" + brd.getbTitle()//
				+"', '" + brd.getbContent()//
				+"', '" + brd.getbWriter()//
				+"', '" + brd.getcDate()//
				+"', '" + brd.getbCnt() + "')";
		System.out.println(sql);
		conn = getConnect();
	
	try {
		stmt = conn.createStatement();
		int r = stmt.executeUpdate(sql);
		System.out.println(r + "건 입력됨");
	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		disconnect();
	}
	}
	//조회Read
	public List<Board> search() {
		conn = getConnect(); 
		List<Board> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date")//
					
						
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	//상세
	
	public Board getNum(int bNum) {
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board board1 =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			rs = psmt.executeQuery(); //담겨져있는 값을 하나 읽어오겠습니다
			if (rs.next()) { 
				board1= new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date")
						, rs.getInt("cnt"));
			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return board1;
	}
	
	
	//수정Update
	
	public void update(Board brd) {
		String sql = "update board"
				+ "set board_content = ?, "
				+ "creation_date = ? "
				+ "where board_num = ?";
		conn = getConnect();
		try { 
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getbContent());
			psmt.setString(2, brd.getcDate());
			psmt.setInt(3, brd.getbNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	
	//삭제Delete
	
	public boolean delete (int bNum) {
		String sql = "delete from board where board_num = ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
		
	}
	
}//end of Class();
