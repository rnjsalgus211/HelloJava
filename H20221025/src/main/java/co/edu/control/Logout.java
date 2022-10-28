package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class Logout implements Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그아웃 - 세션 만료시키기.
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		HttpUtil.forward(req, resp, "member/loginForm.tiles"); //만료시키고 로그인 폼으로 이동.
	}
}
