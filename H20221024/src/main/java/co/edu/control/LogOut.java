package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

public class LogOut implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//현재 세션 정보를 요청해서 지우기.
		HttpSession session = req.getSession();
		session.invalidate(); //웹브라우저에 있는 session값을 삭제하겠습니다.
		
		HttpUtil.forward(req, resp, "memberLog/loginForm.jsp"); //로그아웃 후 로그인화면으로 이동.
	}

}
