<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id"); //로그인이 되어있으면. (session도 값 불러올때 getAttribute).
		String auth = (String) session.getAttribute("auth"); 
	%>
	<%if(id != null) {%>
		<p>현재 접속 중인 아이디: [<%=id %>]</p>
	<%} else { %>
		<p>손님</p>
	<%} %>
	
	<h2>Member 첫페이지.</h2>
	<% if(auth.equals("admin")) { %>
		<a href="./memberAddForm.do">회원정보생성페이지.</a><br> <!-- 회원정보 생성페이지 누르면 .do니까 또 컨트롤러로 감 -->
	<%} %>
	<a href="./memberModifyForm.do">회원정보수정페이지.</a><br> <!-- form이 붙으면 처리가 아니라 화면을 보여주는것. -->
	<a href="./memberRemoveForm.do">회원정보삭제페이지.</a><br>
	<a href="./memberSearchForm.do">회원정보상세페이지.</a><br>
	<a href="./memberList.do">회원목록보기페이지.</a><br>
	
	<%if (id == null){ %>
		<a href="./loginForm.do">로그인화면</a><br>
	<%} else { %>
		<a href="./loginOut.do">로그아웃</a><br>
	<%} %>
	
</body>
</html>