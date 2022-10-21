package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) //response 응답하는 정보
			throws ServletException, IOException {
		
		//content타입을 지정해줍니다.
		response.setContentType("text/html;charset=UTF-8"); //html로 해석해서 웹브라우저가 처리하도록.

		System.out.println("/addMemberServ 페이지입니다.");
		String empId = request.getParameter("employee_id");//파라메터 , employee_id에 실려있는 값을 읽어들이겠습니다?
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
		
		
		System.out.println(empId);

		// 입력.
		EmpDAO dao = new EmpDAO(); // 다른 패키지이기 때문에 임포트 해줘야함.
		EmployeeVO empList = new EmployeeVO(0, null, lName, email, hireDate, jobId);
		System.out.println(empList);
		dao.insertEmp(empList);// employee타입의 데이터가 매개값으로 들어와야함.

		System.out.println("입력완료");
		PrintWriter out = response.getWriter(); //출력스트림. PrintWriter>> 2바이트씩 받아서 출력해주는 객체
		out.print("<h1>입력결과</h1></p>");
		out.print("<h3>사원번호:"+ empList.getEmployeeId()+"</h3></p>");
		out.print("<h3>성씨:"+ empList.getLastName()+"</h3></p>");
		out.print("<h3>이메일:"+ empList.getEmail()+"</h3></p>");
		out.print("<h3>입사일자:"+ empList.getHireDate()+"</h3></p>");
		out.print("<h3>직무:"+ empList.getJobId()+"</h3></p>");
		out.print("<h1>입니다.</h1>");
		out.print("<a href=\"index.html\">메인메뉴</a>");
		 
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
