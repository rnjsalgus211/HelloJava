package co.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

//서블릿이 되려면 HttpServlet이라는 클래스를 상속받아야함.
//init() -> service() 구현.
//제어의 흐름을 개발자가 아니라 서블릿컨테이너가 흐름을 제어해줌. (제어의 역전, IOC)
public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출."); // 인스턴스가 생성될때 한번만 실행이 된다.

	}

	@Override // req : 요청방식
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출."); // FirstServlet이 호출될때마다 실행.
		resp.setContentType("text/html;charset=UTF-8"); // contentType을 지정해저ㅜ야함
		PrintWriter out = resp.getWriter();

		// 사용자의 파라메터(paramet)를 들고와서 처리를 하겠습니다.
		String job = req.getParameter("job");
		EmpDAO dao = new EmpDAO();
		if (req.getMethod().equals("GET")) { // 요청방식이 get이면 or post이면
//			System.out.println("Get 방식의 실행.");
			// get 방식은 정보를 조회할 경우 대체로 사용

			List<EmployeeVO> list = dao.empList(new EmployeeVO(job));
			out.print("<table border='1'>"); // 출력스트림 안에 태그를 작성.
			out.print("<tr><th>사원번호</th><th>성</th><th>이메일</th><th>직무</th></tr>");
			for (EmployeeVO emp : list) {
				out.print("<tr><td>"+emp.getEmployeeId()+"</td>"//
								+ "<td>"+emp.getLastName()+"</td>"//
								+ "<td>"+emp.getEmail()+"</td>"
								+ "<td>"+emp.getJobId()+"</td></tr>");
			}
			out.print("</table>");

		} else if (req.getMethod().equals("POST")) {
			//Post방식은 데이터를 입력할 때.
			String empId = req.getParameter("emp_id"); //emp_id를 읽어서 empId로 넘겨주겠습니다. 중요!!
			String lName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String hDate = req.getParameter("hire_date");
										 
			dao.insertEmp(new EmployeeVO(Integer.parseInt(empId), //사원번호가 int타입이기 때문에. 
											null,  //first_name
											lName, //last_name
											email, //email
											hDate, //hire_date
											job    //job
											));
			
			out.print("<script>alert('입력완료');</script>");
			
			System.out.println("Post 방식의 실행.");

		}
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출.");

	}

}
