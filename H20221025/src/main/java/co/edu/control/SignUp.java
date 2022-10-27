package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//회원가입 처리가 완료되면 member.jsp로 이동하도록구현하기.
		
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("email");
		String user = req.getParameter("responsibility");
		
		BoardService service = new BoardServiceImpl();
		service.SignUp(new MemberVO(id, pw, name, mail, user));

		HttpUtil.forward(req, resp, "member/member.tiles");
	}

}
