package co.newcomers.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.newcomers.prj.common.Command;
import co.newcomers.prj.member.service.MemberService;
import co.newcomers.prj.member.service.impl.MemberServiceImpl;
import co.newcomers.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 전체 회원 정보
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList();
		members = dao.memberList();
		request.setAttribute("members", members);
		
		return "member/membetList";
	}

}
