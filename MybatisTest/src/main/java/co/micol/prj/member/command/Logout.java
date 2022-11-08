package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		
		HttpSession session = request.getSession(); //세션 초기화
		String message = (String) session.getAttribute("name");
		message = message.concat("님 안녕히 가세요~"); //문자열 결합.
		request.setAttribute("message", message);
		session.invalidate(); //서버에 보관하고있는 세션 자체를 완전히 없애는것. (로그아웃처리)
		//session.remove는 내가 원하는 세션만 날릴수있음. 지금은 필요 X
		return "member/memberLogin.tiles";
		
		
//		return "mian.do"; //처음 로그인 안된 상태로 돌리는것.
		
	}

}
