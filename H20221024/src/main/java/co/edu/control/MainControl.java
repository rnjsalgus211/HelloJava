package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;

//가장 처음 호출되는 페이지
public class MainControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpUtil.forward(req, resp, "memberView/main.jsp"); 
			//exec 역할 : memberView밑에 있는 main.jsp를 실행하세요.
	}

}
