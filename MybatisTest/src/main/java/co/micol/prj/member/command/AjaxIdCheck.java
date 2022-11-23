package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax 아이디 중복 체크.
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("id"); //"id"변수는 memberLoginForm=> idCheck() 밑에 ajaxIdCheck.do?id 의 id.
		boolean b = dao.isMemberIdCheck(id); //id값을 넘기면? 존재할경우(false) true & false.
		String result = "0" +""; //디폴트가 사용 가능 한 것으로..?
		if(b) { //넘어온 값이 false면. (사용가능하지않으면, 아이디가 중복이면.)
			result = "1";
		}
		return "ajax:"+result;
		//ajax는 호출한 페이지에다가 그냥 뿌려줘야됨. ajax로 결과를 받을때는 "ajax:"로 ajax로 받았다고 호출 페이지에 알려주어야함.
	}

}
