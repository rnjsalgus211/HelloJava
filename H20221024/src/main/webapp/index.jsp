<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.getRequestDispatcher("main.do").forward(request, response); 
%>

<!--바로 객체를 만들어서 forward해주는것.
 //main.do라는 페이지를 다시 요청하였음. .do로 끝나니까 FrontController를 찾아감. (첫번째 실행)  -->