<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(LoginForm.jsp)</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="./Login.do" method="post">
		ID: <input type="text" name="id"><br> 
		Passwd: <input type="password" name="passwd"><br>
		<input type="submit" value="로그인"><br>
		<input type="reset" value="초기화"><br>
	</form>

</body>
</html>