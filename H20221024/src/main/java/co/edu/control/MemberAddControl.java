package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberAddControl implements Command {

	
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 값에 따라서 ...
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("email");
		
		MemberVO vo = new MemberVO(id, pw, name, mail);
		
		// DB에 입력처리.
		MemberService service = new MemberServiceImpl();
		service.addMember(vo);
		
		
		//처리된 결과를 보여주는 페이지로 이동하겠습니다. memberInsertOutput으로 이동.
		HttpUtil.forward(req, resp, "memberResult/memberInsertOutput.jsp");
		

	}

}
