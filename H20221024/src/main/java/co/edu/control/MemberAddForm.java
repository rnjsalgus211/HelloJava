package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

//입력하는 화면으로 페이지를 이동시키겠습니다.
public class MemberAddForm implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.forward(req, resp, "memberView/memberInsert.jsp");
		//exec를 실행 > memberInsert를 열어줌.
	}

}
