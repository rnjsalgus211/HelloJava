<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보상세페이지(memberSearch.jsp)</title>
</head>
<body>
	<%
		String result = (String) request.getAttribute("sid"); //sid라는 값을 찾아오겠습니다.(MemberSearchForm에서)
	%>
	<h3>회원정보 검색</h3>
	<form action="./memberSearch.do" method="post">
	    <input type="hidden" name="job" value="search">
		ID: <input type="text" name="id" value="<%=result %>"><br>
		<input type="submit" value="조회">
	</form>

</body>
</html>