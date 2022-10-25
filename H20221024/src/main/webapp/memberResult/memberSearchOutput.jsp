<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보조회결과(memberSearchOutput.jsp)</title>
</head>
<body>

	<%
	MemberVO result = (MemberVO) request.getAttribute("memberInfo"); //request라는 객체를 선언한적이없는데 존재함. memberSearchControl에서 페이지를 재 진행함. 그 때 요청정보와 응답정보를 페이지로 넘김
	//memberInfo를 가져와서 쓰고싶음.....
	%>

	<h3>회원상세정보 보기</h3>
	<%if (result != null) {%>
		<p>회원아이디:<%=result.getId()%></p>
		<p>회원이름:<%=result.getName()%></p>
		<p>회원이메일:<%=result.getEmail()%></p>
	<%} else {%>
		<p>조회된 정보가 없습니다!</p>
	<%} %>
	
	<%@ include file ="home.jsp" %> <!-- 페이지내에 다른 페이지를 추가. include 지시자 -->
</body>
</html>