<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="./js/ajaxjquery.js"></script>
<div id="header">
  <label>도서코드: <input type="text" name="bookCode"> </label><br>
</div>

<div id="show">
	<table border="1">
		<thead>
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</div>
