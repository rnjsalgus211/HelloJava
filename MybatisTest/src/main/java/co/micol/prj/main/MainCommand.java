package co.micol.prj.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 처음 들어올때 보여줄 페이지.
		return "main/main"; // viewPage에 "main/mian"값이 넘어감. viewResolv에 가면(프론트 컨트롤러)끝에 .do가 없기때문에 [/WEB-INF/views/main/main.jsp]와 같이 값이 넘어감.
	}

}
