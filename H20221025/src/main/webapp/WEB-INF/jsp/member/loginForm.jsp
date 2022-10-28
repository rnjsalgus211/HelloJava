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
	
	<a href="passwdReConfirm.do">비밀번호 재전송</a>
	<!-- passwdReConfirm.jsp: 아이디를 입력하고 재전송버튼을 누르면 메일주소로 변경된 비밀번호 전송되도록.(바뀐 비번으로 로그인 할수있도록) 
		 passwdReConfirm.do : 아이디를 받아서 이메일정보로 메일을 발송하도록
	-->
	

</body>
</html>