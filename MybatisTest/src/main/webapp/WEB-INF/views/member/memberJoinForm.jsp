<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원 가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" onsubmit="return formSubmit()" method="post">
			<div>
				<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td width="270">
						<input type="text" id="id" name="id" required="required">&nbsp;&nbsp;
						<button type="button" id="btn" value="No" onclick="idCheck()">중복체크</button>
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
						<input type="password" id="passwd" name="passwd" required="required">
					</td>
				</tr>
				<tr>
					<th>패스워드 확인</th>
					<td>
						<input type="password" id="passwd1" name="passwd1" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="name" name="name" required="required">
						
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="email" id="email" name="email" required="required">
					</td>
				</tr>
				</table>
			</div><br/>
			<div>
				<input type="submit" value="회원가입">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	function formSubmit() {
		if(frm.btn.value == 'No') {
			alert("아이디 중복체크를 해주세요.");
			return false;
		} 
		if(frm.passwd.value != frm.passwd1.value){
			alert("패스워드가 확인값과 일치하지 않습니다.");
			frm.passwd.value = ""; 
			frm.passwd1.value = "";
			frm.passwd.focus();
			return false;
		}
		
		return true;
	}
		
	function idCheck(){ //아이디 중복 체크
		let id = frm.id.value;
		let url = "ajaxIdCheck.do?id="+id;
		fetch(url)
			.then(response => response.text())
			.then(data => { //결과 처리 함수 
				if(data == 1){
					alert(id + "는 사용가능한 아이디입니다.");
					frm.btn.value = 'Yes';
				} else {
					alert(id + "는 사용중인 아이디입니다.")
					frm.id.value ="";
					frm.id.focus();
				}
			});
	}
</script>
</body>
</html>