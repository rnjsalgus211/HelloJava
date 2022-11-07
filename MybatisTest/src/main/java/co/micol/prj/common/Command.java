package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//request : 클라이언트에서 요청 할 때 넘어오는 값들을 담아주는곳.
	//response : 내가 응답하는 객체.
	public String exec(HttpServletRequest request, HttpServletResponse response);
}
