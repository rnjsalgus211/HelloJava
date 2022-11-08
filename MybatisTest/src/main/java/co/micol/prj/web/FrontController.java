package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.command.BookList;
import co.micol.prj.common.Command;
import co.micol.prj.main.MainCommand;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.Logout;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;

/**
 * 모든요청을 받아들이는 컨트롤러.
 */
@WebServlet("*.do") //어노테이션을 이용해서 매핑한것.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>(); //명령을 저장 할 공간을 키값과 밸류값으로 만들어준것.
    
    public FrontController() {
        super();
    }
    
    //요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령. (/main.do라고 들어오면) map.put에다가 요청을 쭉 써나가면 됨.
		map.put("/bookList.do", new BookList()); //책 목록보기
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //멤버 로그인 처리
		map.put("/logout.do", new Logout()); //로그아웃.
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //ajax를 이용한 아이디 중복 체크
		map.put("/memberJoin.do", new MemberJoin());   //회원가입
	}
	

	//요청을 분석하고 실행, 결과를 돌려주는 곳. (가장 간단한 viewResolve)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
		String uri = request.getRequestURI(); //요청한 uri를 구함
		String contextPath = request.getContextPath(); //루트를 구함.(contextPath)
		String page = uri.substring(contextPath.length()); //컨텍스트패스 빼면 실제 요청이 남는다.
		
		Command command = map.get(page); //init메소드에서 수행 할 요청 찾기(가져온다) map은 키값 넣어주면 나한테 밸류값 리턴.
		String viewPage = command.exec(request, response); //명령을 수행하고 결과물 돌려받음.
		
		//인터페이스 개념 중요! (자바는 멀티 상속이안되기때문)
	
		//viewResolve파트
		if(!viewPage.endsWith(".do") && viewPage != null) { //리턴되는 문자열에서 마지막에 .do가 포함되어있지 않다면.
			//ajax처리 할 곳. : 요청한 페이지에 결과를 주는 것.
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5)); //ajax:까지 자르고 그 뒤가 필요. (결과만 리턴)
				return;
			}
			
			//tiles 처리 할 곳.
			if(!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" +viewPage+".jsp";	//타일즈를 안태움?? 무슨말이지		
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // 값을 실어서 response.request 객체 보냄. (휴대폰 들고 AS센터 감)  값을 가지고 감
		}else {
			response.sendRedirect(viewPage); //*.do로 들어온다면 돌아가는곳? > 다시 명령을 실행시킴. (sendRedirect -권한을 위임하는데 값 없이 객체만그냥 보냄. (휴대폰 안들고 AS센터만 감 )) 값 없이 그냥 감
		}
	}
}
