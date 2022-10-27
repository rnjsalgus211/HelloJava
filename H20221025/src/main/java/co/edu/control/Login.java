package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class Login implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 아이디, 패스워드 => 검증해서 맞으면 session객체에 id값을 저장.
		//로그인 성공했습니다.
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		BoardService service = new BoardServiceImpl();
		MemberVO result = service.login(id, pw);
		
		if(result != null) {
			req.setAttribute("logInfo", result);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getRespons());
			
			HttpUtil.forward(req, resp, "member/login.tiles");
			
			
		}else {
			HttpUtil.forward(req, resp, "member/loginForm.tiles");
		}
		
		
		
		
	}

}
