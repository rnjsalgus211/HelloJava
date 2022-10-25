package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class MemberSearchForm implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면 open.
		String id = req.getParameter("id"); //아이디를 넘겨주겠습니다.
		
		req.setAttribute("sid", id); //sid라는 값으로 넘겨주겠습니다.
		
		
		
		HttpUtil.forward(req, resp, "memberView/memberSearch.jsp");
	}

}
