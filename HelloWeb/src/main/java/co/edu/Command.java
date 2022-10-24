package co.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//req:요청정보, resp:응답정보 를 매개값으로 넘겨주겠습니다.
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
