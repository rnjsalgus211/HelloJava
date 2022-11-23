package co.micol.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class AjaxBookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// json 타입의 데이터가 필요함.
		BookService dao = new BookServiceImpl();
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValueAsString(books);
		
		return null;
	}

}
