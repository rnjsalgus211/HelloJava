<%@page import="co.edu.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language (EL) JSP Standard Tag Library(JSTL)</title>
</head>
<body>
	<%
		String info = (String) application.getAttribute("info");
		System.out.println(info);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = (List<BoardVO>)dao.pageList(1);
		
		request.setAttribute("bList", list);
		
	%>
	<p>${info }</p> <!-- 간단한 표현식을 처리할 수 있는 언어를 제공. 달러괄호 안에 사용--> 
	<p>${"Hongkildong" eq "Hong" }</p> <!-- eq는 예약어 equals -->
	<p>${55+22 }</p>
	<p>${info }</p>
	<p>${param.page }</p>
	<p>app: ${sessionScope.hissession eq null }</p>
	
	<c:set var="myName" value="홍길동"></c:set>
	<p>${myName }</p>
	<c:out value="${myName }"></c:out> 
	
	<c:if test="${info eq 'hong' }">
		<p>같습니다</p>
	</c:if>
	
	<c:if test="${!info2 }">
		<p>값이 없습니다.</p>
	</c:if>
	
	<c:set var="score" value="75"></c:set>
	
	<c:choose>
		<c:when test="${score > 90 }"><p>A학점</p></c:when> 
		<c:when test="${score > 80 }"><p>B학점</p></c:when> 
		<c:when test="${score > 70 }"><p>C학점</p></c:when> 
		<c:otherwise><p>불합격</p></c:otherwise>
	</c:choose>
		
		<c:forEach var="i" begin="1" end="10" step="1">
			<p>${i }</p>
		</c:forEach>
		
		<c:forEach var="board" items="${bList }">
			<p>글번호: ${board.boardNo },작성자: ${board.title }, 작성자:${board.writer}</p>
		</c:forEach>
	
	
	
</body>
</html>