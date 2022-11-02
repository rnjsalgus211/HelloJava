package co.edu.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;

@WebServlet("/SchedulesServlet")
public class SchedulesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SchedulesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> result = dao.calendarInfo();
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(result));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String title =request.getParameter("title");
		String sDate =request.getParameter("start");
		String eDate =request.getParameter("end");
		MemberVO vo = new MemberVO();
		vo.setTitle(title);
		vo.setSDate(sDate);
		vo.setEDate(eDate);
		
		MemberDAO dao = new MemberDAO();
		dao.insertCalendar(vo);
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
		
	}

}
