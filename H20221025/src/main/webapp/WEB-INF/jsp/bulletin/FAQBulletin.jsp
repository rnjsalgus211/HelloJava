<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- bulletin/bulletin.tiles -->
<!-- tiles로 확장자가 끝나야함. -->
<h3>자주하는질문</h3>
<table border='1'>
<thead>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${fList }">
			<tr>
				<td><a href="FAQ.do?bno=${vo.FaqNo}">${vo.FaqNo}</a></td>
				<td>${vo.title }</td>
				<td>${vo.writer }</td>
				<td>${vo.writeDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p />

${page }
<p />

<div class='pagination'>
	<c:if test="${page.prev }">
		<a href="FAQBulletin.do?page=${page.startPage-1}">&lt;&lt;</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }" step="1">
		<c:choose>
			<c:when test="${page.pageNum ==i }">
				<a  class="active" href="FAQBulletin.do?page=${i }"> ${i }</a>
			</c:when>
			<c:otherwise>
					<a href="FAQBulletin.do?page=${i }"> ${i }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${page.next }">
		<a href="FAQBulletin.do?page=${page.endPage+1}">&gt;&gt;</a>
	</c:if>
</div>