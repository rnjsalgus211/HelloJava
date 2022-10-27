<%@page import="co.edu.board.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- bulletin/bulletin.tiles -->
<!-- tiles로 확장자가 끝나야함. -->
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("bList");
PageVO paging = (PageVO) request.getAttribute("page");
%>
<h3>게시판 페이지입니다.</h3>
<table border='1'>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
	</tr>
	<body>
		<%
		for (BoardVO vo : list) {
		%>
	<tr>
		<td><a href="searchBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getBoardNo()%></a></td>
		<td><%=vo.getTitle()%></td>
		<td><%=vo.getWriter()%></td>
		<td><%=vo.getWriteDate()%></td>
	</tr>
	<%
	}
	%>


</table>
<p />

<%=paging.toString()%>
<p />


<%
	if(paging.isPrev()) {
%>
	<a href="bulletin.do?page=<%=paging.getStartPage()-1%>">&lt;&lt;</a>
<%	
	}
%>

<%
	for(int i = paging.getStartPage(); i <=paging.getEndPage(); i ++){
%>		
	<a href="bulletin.do?page=<%=i%>"> <%=i %></a>
<%	
	}
%>

<%
	if(paging.isNext()) {
%>
	<a href="bulletin.do?page=<%=paging.getEndPage()+1%>">&gt;&gt;</a>
<%	
	}
%>
