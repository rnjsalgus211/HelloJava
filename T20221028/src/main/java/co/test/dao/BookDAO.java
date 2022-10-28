package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	//목록
	public List<BookVO> bookList() {
		List<BookVO> list = new ArrayList();
		getConnect();
		String sql ="select * from book_info";
				

		try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery(sql);
		while(rs.next()) {
			
			list.add(new BookVO(rs.getString("book_code")
							, rs.getString("book_title")
							, rs.getString("book_author")
							, rs.getString("book_press")
							, rs.getInt("book_price")));
			
		}
		}catch(SQLException e) {
			
		}finally {
			disconn();
		}
		return list;
	}
	
	//한건 조회
	public BookVO selectBook(String bookCode) {
		getConnect();
		String sql = "select * from book_info where book_code = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
			BookVO vo = new BookVO();
			vo.setBookCode(rs.getString("book_code"));
			vo.setBookTitle(rs.getString("book_title"));
			vo.setBookAuthor(rs.getString("book_author"));
			vo.setBookPress(rs.getString("book_press"));
			vo.setBookPrice(rs.getInt("book_price"));
			return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
		
		
	}
	
	//추가
	public void insertBook(BookVO book) {
		getConnect();
		
		String sql = "select create_bookcode from dual";
		String sql2 = "insert into book_info (book_code, book_title, book_author, book_press, book_price) "
				+ "values (?, ?, ?, ?, ?) ";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			String nextCode = "";
			if(rs.next()) {
				nextCode = rs.getString(1);
			}
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, nextCode);
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getBookAuthor());
			psmt.setString(4, book.getBookPress());
			psmt.setInt(5, book.getBookPrice());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 입력.");

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}
	
	//수정
	public void updateBook(BookVO book) {
		getConnect();
		String sql = "update book_info "
				+ "set book_title =?, "
				+ "    book_author =?, "
				+ "	   book_press =?, "
				+ "    book_price =? "
				+ "where book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}
	
	//삭제
	public void deleteBook(String bookCode) {
		getConnect();
		String sql = "delete from book_info where book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}
}
