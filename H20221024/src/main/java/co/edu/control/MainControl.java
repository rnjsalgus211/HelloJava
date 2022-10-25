package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

//가장 처음 호출되는 페이지
public class MainControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(); //요청정보에서 세션정보를 읽어오도록 하겠습니다.
		
		String id = (String)session.getAttribute("id"); //session에 id정보가 있는지 뒤져보고 
		
		//값이 있으면 main페이지로 이동하고, 로그인 해놓은 세션정보가 없으면 로그인 페이지로 이동하도록.
		if(id != null) {	
		HttpUtil.forward(req, resp, "memberView/main.jsp");//exec 역할 : memberView밑에 있는 main.jsp를 실행하세요.
		}else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");
		}
		
	}

}
