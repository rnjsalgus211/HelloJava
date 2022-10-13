package co.edu.board;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Create Read Update Delete CRUD 기능 구현
public class BoardDAO extends DAO {

	// 아이디 패스워드 설정
	public int login(String id, String passwd) {

		String sql = "select * from user2 where id = ? and passwd = ? ";
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

	// 추가Create
	public void insert(Board brd) {
		System.out.println(brd);
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n" + "values("
				+ brd.getbNum()//
				+ ", '" + brd.getbTitle()//
				+ "', '" + brd.getbContent()//
				+ "', '" + brd.getbWriter()//
				+ "')";
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

	// 조회Read
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select board_num, board_title, board_writer, creation_date from board order by board_num");
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date")//

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상세
	public Board getNum(int bNum) {
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board board1 = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			rs = psmt.executeQuery(); // 담겨져있는 값을 하나 읽어오겠습니다
			if (rs.next()) {

				board1 = new Board(rs.getInt("board_num")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date"), rs.getInt("cnt"));

				count(bNum);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return board1;
	}

	public void count(int bNum) {
		String sql = "update board set cnt = cnt+1 where board_num = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			psmt.executeUpdate(); // 담겨져있는 값을 하나 읽어오겠습니다
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 수정Update

	public void update(Board brd) {
		String sql = "update board" + " set board_content = ?, " + "creation_date = sysdate " + "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getbContent());
			psmt.setInt(2, brd.getbNum());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	// 삭제Delete

	public boolean delete(int bNum) {
		String sql = "delete from board where board_num = ? ";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);

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

	// 댓글 달기

	public void reply(Reply rep) {
		String sql = "insert into reply (rep_seq, board_num, rep_content, rep_writer, creation_date)\r\n"
				+ "values(reply_seq.nextval, " 
				+ rep.getBoardNum() + ", '"
				+ rep.getRepCon()+"', '"//
				+ rep.getRepWriter() + "', sysdate)";
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
	//댓글 조회
	public List<Reply> repSearch(int bNum) {
		String sql = "select * from reply where board_num = ?";
		conn = getConnect();
		List<Reply> list1 = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			
			rs = psmt.executeQuery(); // 담겨져있는 값을 하나 읽어오겠습니다
			while (rs.next()) {

				list1.add(new Reply(rs.getInt("rep_seq")//
						, rs.getInt("board_num")//
						, rs.getString("rep_content")//
						, rs.getString("rep_writer")//
						, rs.getString("creation_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list1;
	}
		
	
	public boolean repDelete(int repNum) {
		
		String sql = "delete from reply where rep_seq = ? ";
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
	
}
// end of Class();
