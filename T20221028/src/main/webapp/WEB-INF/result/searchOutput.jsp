<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>조회결과페이지</h3>
	<table border ="1">
	
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>도서저자</th>
			<th>도서출판사</th>
			<th>도서가격</th>
		</tr>
		<tr>
			<td>${book.bookCode}</td>
			<td>${book.bookTitle }</td>
			<td>${book.bookAuthor }</td>
			<td>${book.bookPress }</td>
			<td>${book.bookPrice }</td>
		</tr>
	</table>
	
	
    <a href="main.do">첫페이지</a>

</body>
</html>