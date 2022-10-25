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

//멤버 조회
public class MemberSearch implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id를 입력. memberResult/memberSearchOutput.jsp
		String path = "";
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		
		if(job.equals("search")) { //search면 그냥 결과 보여주면 되고
			path = "memberResult/memberSearchOutput.jsp";
			
		} else if (job.equals("update")) { //update하면 수정 페이지 다시 로드되도록
			path = "memberView/memberUpdate.jsp";
		} else if (job.equals("delete")) {
			path = "memberView/memberDelete.jsp";
		}
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.findMember(id); // vo를 이동하는 페이지에 넘겨주고싶음.

		// 요청정보의 속성에 vo의 값을 담아서 넘길수있다.
		req.setAttribute("memberInfo", vo);

		HttpUtil.forward(req, resp, path);

	}

}
