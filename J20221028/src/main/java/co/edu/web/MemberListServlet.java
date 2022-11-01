package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;


@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    public MemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		//[{"id": "user1", "name": "홍길동", "email": "email.com", "responsibility": "user"},{},{}] => 제일 마지막 데이터에는 콤마 없어야됨.
		//데이터가 3건? 1, 2, 3 방식으로 들어감.(콤마 유의)
	
//		String json = "[";
//		for(int i=0; i<list.size(); i++) {
//			json += "{\"id\": \""+list.get(i).getId() // \이스케이프 문자: 따옴표를 따옴표문자로 처리하겠습니다.(문자열 표기하는 따옴표 X)
//					+"\", \"name\": \""+list.get(i).getName()//
//					+"\", \"email\": \""+list.get(i).getEmail()//
//					+"\", \"responsibility\": \""+list.get(i).getRespons()+"\"}";//
//			if(i < list.size() - 1) {
//				json += ",";
//			}
//		}
//		json += "]"; //끝부분에 닫는 괄호
		
		//위의 긴 코드를 두줄로 해결가능.
		Gson gson = new GsonBuilder().create();
		//바꿔야할 객체가 list이기 때문에 아래 코드처럼 작성.
		response.getWriter().print(gson.toJson(list));//응답정보에 반환.
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			System.out.println("dopost");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=utf-8");
			
			String job = request.getParameter("job");
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			//job = > 등록, 삭제 구분
			if(job.equals("delete")) {
				if(dao.deleterMember(id)) {
					response.getWriter().print("success");
				}else {
					response.getWriter().print("fail");
				}
				
			}else if (job.equals("insert")) {
			
			String pw = request.getParameter("passwd");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(email);
			vo.setName(name);
			
			dao.insertMember(vo);
			
			Gson gson = new GsonBuilder().create(); //gson인스턴스 호출. 자동으로 json형식의 데이터로 변환해줌.
			//{"id":"user1", "passwd":.....} 
			
			response.getWriter().print(gson.toJson(vo)); //결과값 받아오는것. response(응답정보를 담은 객체) getWriter():출력스트림. print> 웹브라우저에 보여줌.
			}
			
			
	}

	}
