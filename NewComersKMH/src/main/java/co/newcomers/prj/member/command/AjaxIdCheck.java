package co.newcomers.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.newcomers.prj.common.Command;
import co.newcomers.prj.member.service.MemberService;
import co.newcomers.prj.member.service.impl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//id 중복 체크
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("id");
		System.out.println(id);
		boolean b = dao.isMemberIdCheck(id);
		System.out.println(b);
		String result = "0";
		
		if(b) {
			result = "1";
		}
		return "ajax:"+result;
	}

}
