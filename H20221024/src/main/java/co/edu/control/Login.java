package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class Login implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		MemberService service = new MemberServiceImpl(); //id, pass값을 받아서 로그인정보가 있으면 vo값을 리턴해주고 없으면 null값을 리턴.
		MemberVO result = service.login(id, pw);
		
		//회원아이디와 비밀번호가 맞으면 메인페이지, 틀리면 로그인페이지로
		if(result != null) {
		req.setAttribute("logInfo", result);
		
		HttpSession session = req.getSession(); 
		session.setAttribute("id", result.getId());
		session.setAttribute("auth", result.getResponsibility()); //admin/user권한 구분
		
			HttpUtil.forward(req, resp, "memberView/main.jsp"); //로그인을 했을 때 메인페이지로 이동.
		}else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp"); //로그인 실패시 다시 로그인화면으로.
		}
	}

}
