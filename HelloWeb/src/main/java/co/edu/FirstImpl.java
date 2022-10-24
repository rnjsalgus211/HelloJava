package co.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstImpl implements Command{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		// first.do를 호출하면 first.jsp 페이지를 호출하도록.
		RequestDispatcher rd= req.getRequestDispatcher("WEB-INF/jsp/first.jsp");
		rd.forward(req, resp);
//		resp.sendRedirect("WEB-INF/jsp/first.jsp"); //응답정보가 가지고있는 sendRedirect 메소드로 jsp/first.jsp를 호출하겠습니다.
		
		
	}	

}
