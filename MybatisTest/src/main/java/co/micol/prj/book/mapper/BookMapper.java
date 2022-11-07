package co.micol.prj.book.mapper;

import java.util.List;

import co.micol.prj.book.vo.BookVO;

//대부분은 service인터페이스랑 같음.
//왜 두개 만드는지? 기본적인 CRUD는 같지만 세부적인 parameter선택이 다를 수 있다.
public interface BookMapper { 
	List<BookVO> bookSelectList(); //book 전체리스트 가져오기 or getBookList (R)
	BookVO bookSelect(BookVO vo);  //한권의 책 상세내역 가져오기.(R) getBook
	int bookInsert(BookVO vo);     //도서입력(C) setBook
	int bookDelete(BookVO vo);     //도서삭제(D) deletBook
	int bookUpdate(BookVO vo);     //도서변경(U) updateBook
	
}
