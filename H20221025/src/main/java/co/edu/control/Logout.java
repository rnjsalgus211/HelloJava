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
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		HttpUtil.forward(req, resp, "member/loginForm.tiles"); //원래는 하나하나 지정해줬지만, member폴더 밑에 member.jsp를 불러달라는 걸 tiles.xml에서 지정했다. 
	}
}
