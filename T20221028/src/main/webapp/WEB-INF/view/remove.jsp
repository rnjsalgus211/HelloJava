<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서삭제조회</h3>
    <form action="./searchBook.do" method="get">
        <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>

    <!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->
	<form action="./removeBook.do" method="get">
		북코드 : <input type="text" name="bookCode1"><br>
		<input type="submit" value="삭제">
	</form>
		
    <a href="main.do">첫페이지</a>

</body>

</html>