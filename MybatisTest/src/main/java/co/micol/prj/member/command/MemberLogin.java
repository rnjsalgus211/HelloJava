package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		MemberService dao = new MemberServiceImpl(); //인터페이스는 구현체(Impl)을 통해서.
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession(); //세션값을 사용하기 위해 
		
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		
		String message = "아이디 또는 패스워드가 틀립니다."; //일단 실패했다고 가정하고 실패메세지 담음.
		
		member = dao.memberLogin(id, password);
		
		if(member != null) { //member가 비어있지 않다면? (값을 가지고 있다면, id-passwd가 패스되었음.)
			session.setAttribute("id", member.getId()); //세션객체에 id라는 변수로 member.getId()값을 담아라. (세션에 값을 담아놔라)
			session.setAttribute("name", member.getName());
			session.setAttribute("responsibility", member.getResponsibility());
			message = member.getName() + "님 환영합니다!";
		}
		
		request.setAttribute("message", message); //메세지 실어서 보내기.	
		return "member/memberLogin.tiles"; 
	}

}
