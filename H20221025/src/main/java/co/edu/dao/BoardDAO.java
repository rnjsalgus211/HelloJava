package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.FaqVO;
import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// 입력, 조회, 수정, 삭제의 기능을 구현.
	public BoardVO insertBoard(BoardVO vo) {
		// 입력 처리중에 에러가 발생하면 .. null!
		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer, image ) " + "values (?, ?, ?, ?, ?)";

		try {
			// 시퀀스 얻어오는 쿼리
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			// insert하기 위한 작업
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());

			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; //실패할 경우에는 null을 반환.

	}

	public BoardVO searchBoard(int boardNo) { //한건조회
		getConnect();
		String sql = "select * from tbl_board where board_no = ?";
		BoardVO board = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				return board;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public List<BoardVO> boardList(BoardVO vo) { // 목록조회
		List<BoardVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from tbl_board " + "where 1 = 1" + " and title like '%'||?||'%' "
				+ " and content like '%'||?||'%' " + " and writer like '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 리턴되는데, 0이면 false! 처리되면 true.
		getConnect();
		String sql = "update tbl_board "
				+ "set content =? "
				+ "where board_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getBoardNo());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경.");
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

	public boolean deleteBoard(int boardNo) {
		// 처리건수가 리턴되는데, 0이면 false! 처리되면 true.
		getConnect();
		String sql = "delete from tbl_board where board_no = ?"; 
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제.");
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
	
	//페이지. 전체 건수를 기준으로 10개씩 자름. 후에는 검색결과에서 전체건수/10씩도 나와야한다.
	public int totalCnt() {
		getConnect();
		String sql = "select count(1) from tbl_board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) { // 값이 있으면
				int cnt = rs.getInt(1); //가지고 온 칼럼 첫번째(count)
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}
	
	public List<BoardVO> pageList(int page){ // 페이지 수를 적으면 그만큼만 갖고옴
		getConnect();
		List<BoardVO> list = new ArrayList<>();
		String sql = "select b.* "//
				+ "from (select rownum rn, a.* "//
				+ "      from   (select * "//
				+ "              from tbl_board "//
				+ "              order by board_no desc) a  "//
				+ "      where rownum <= ?) b "//
				+ "where b.rn >= ?";
		
		int from = (page - 1) * 10 + 1; //1, 11
		int to = (page * 10); //10, 20
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to); //rownum
			psmt.setInt(2, from); //b.rn
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				
				list.add(board);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<FaqVO> pageFAQ(int page){ // 페이지 수를 적으면 그만큼만 갖고옴
		getConnect();
		List<FaqVO> list = new ArrayList<>();
		String sql = "select b.* "//
				+ "from (select rownum rn, a.* "//
				+ "      from   (select * "//
				+ "              from tbl_FAQ "//
				+ "              order by FAQ_no desc) a  "//
				+ "      where rownum <= ?) b "//
				+ "where b.rn >= ?";
		
		int from = (page - 1) * 10 + 1; //1, 11
		int to = (page * 10); //10, 20
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to); //rownum
			psmt.setInt(2, from); //b.rn
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				FaqVO board = new FaqVO();
				board.setFaqNo(rs.getInt("FAQ_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				
				list.add(board);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//qna 테이블 글 등록
	public BoardVO insertQna(BoardVO vo) {
		// 입력 처리중에 에러가 발생하면 .. null!
		getConnect();
		String sql = "select qna_seq.nextval from dual";
		String sql2 = "insert into tbl_qna (qna_no, title, content, writer, image ) " + "values (?, ?, ?, ?, ?)";

		try {
			// 시퀀스 얻어오는 쿼리
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			// insert하기 위한 작업
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());

			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; //실패할 경우에는 null을 반환.

	}
	//회원가입
	public MemberVO SignUp(MemberVO vo) {
		// 입력 처리중에 에러가 발생하면 .. null!
		getConnect();
		String sql = "insert into members (id, passwd, name, email, responsibility) " + "values (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getRespons());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
			if (r > 0) {
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	//로그인
	public MemberVO login(String id, String passwd) {
		String sql = "select * from members where id = ? and passwd = ?";
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			
			rs = psmt.executeQuery();
			
			if(rs.next());
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRespons(rs.getString("responsibility"));
				return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
		
	}
	
	//회원목록출력하기 for member/memberList.jsp에서 jstl 이용.
	public List<MemberVO> memberList(){
		List<MemberVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from members";
		
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				
				list.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	//아이디를 받아서 회원 목록 출력하기.
	
	public MemberVO getInfo(String id){
		getConnect();
		String sql = "select * from members where id = ? ";
		MemberVO member = null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO(rs.getString("id")
						,rs.getString("passwd")
						,rs.getString("name") 
						,rs.getString("email")
						,rs.getString("responsibility"));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return null;
	}
	
	// 수정
	public boolean update(MemberVO vo) {
		String sql = "update members " + " set passwd = ? " + " where id = ?";
		conn = getConnect();
		
		try {
		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getId());
			
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
			if(r >0) {
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
	
	
	

