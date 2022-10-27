<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  <!-- request객체는 jsp파일이 자바파일로 바뀌어지면서 생성되는 내장객체. -->
	<% String paging = (String) request.getParameter("page"); 
		session.getAttribute("id");
		System.out.println(paging);
		application.setAttribute("info", "hong"); //H20221025라는 어플리케이션이 실행되면 application객체가 생성됨.
		session.setAttribute("mysession", "1234");
		session.setAttribute("yoursession", "5678");
	%>
	
</body>
</html>