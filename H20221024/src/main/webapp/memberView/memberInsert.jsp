<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInsert.jsp</title>
</head>
<body>
  <h3>회원가입</h3> <!-- 두번째 실행. memberAdd.do 실행하러 FrontController로 이동. -->
  <form action="./memberAdd.do" method="post">
  ID: <input type="text" name="id"><br>
  PW: <input type="password" name="passwd"><br>
  Name: <input type="text" name="name"><br>
  Mail: <input type="email" name="email"><br>
  <input type="submit" value="등록">
  
  </form>
</body>
</html>