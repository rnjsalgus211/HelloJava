package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet {
	
		Map<String, Command> control = new HashMap<>();
	
		@Override
		public void init() throws ServletException {
			control.put("/main.do", new MainControl()); //첫번째로 main.do를 실행. 첫화면
			control.put("/memberAddForm.do", new MemberAddForm()); //두번째 실행. 입력화면
			control.put("/memberAdd.do", new MemberAddControl()); //마지막 실행.
			control.put("/memberModifyForm.do", new MemberModifyForm()); //수정 화면을 열어줌.
			control.put("/memberModify.do", new MemberModify()); //수정 기능.
			}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uri = req.getRequestURI();
			String contextPath = req.getContextPath();
			String path = uri.substring(contextPath.length());
			
			
			Command command = control.get(path);
			command.exec(req, resp);
			
			
		}

}
