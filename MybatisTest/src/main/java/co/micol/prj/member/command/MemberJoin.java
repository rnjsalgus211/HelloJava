package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원입력
		MemberService dao = new MemberServiceImpl(); //db에 넣어야겠다면? dao 필요.
		MemberVO vo = new MemberVO(); //vo로 받을건지, list로 받을건지?
		
		//vo에 값 담아주고.
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		
		//메소드 호출하고
		int n = dao.memberInsert(vo); //memberInsert에 vo실어보내기.
		String message = "입력이 실패 했습니다.";
		
		//성공일 경우
		if(n > 0) { 
			message = "회원가입이 정상적으로 처리되었습니다.";
		}
		
		request.setAttribute("message", message); //메세지를 표시하는 창.
		return "member/memberLogin.tiles";
	}

}
