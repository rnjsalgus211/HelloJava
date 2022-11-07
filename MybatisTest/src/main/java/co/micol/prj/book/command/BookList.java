package co.micol.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 책 목록 가져오기
		BookService dao = new BookServiceImpl(); //구현체를 통해서 초기화를 함.
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList();
		request.setAttribute("books", books);
		
		return "book/bookList";
	}

}
