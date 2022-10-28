package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String code = request.getParameter("bookCode1");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		int price2 = Integer.parseInt(price);
		BookService service = new BookService();
		service.modifyBook(new BookVO(code, title, author, press, price2));
		
		System.out.println(title);
		HttpUtil.forward(request, response, "WEB-INF/result/modifyOutput.jsp");
	
	}
	
	

}
