<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="./signUp.do" method="post">
		ID: <input type="text" name="id"><br>
		Passwd: <input type="password" name="passwd"><br>
		Name: <input type="text" name="name"><br>
		Mail: <input type="email" name="email"><br>
		권한: <input type="text" name="responsibility" value="user" readonly><br>
		<input type="submit" value="회원가입"><br>
		<input type="reset" value="초기화"><br>
		
	</form>
</body>
</html>