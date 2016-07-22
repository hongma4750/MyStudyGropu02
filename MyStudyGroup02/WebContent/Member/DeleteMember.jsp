<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="Javascript/Member/deleteRealy.js"></script>
<script src="Javascript/Member/goBack.js"></script>
</head>
<body>

<h2>탈퇴...ㅠㅠ</h2>
<form action="deletemember.do" name="frm" method="post">
<table>
<tr>
	<td>아이디</td>
	<td><input type="text" name="m_id"></td>
</tr>

<tr>
	<td>비밀번호</td>
	<td><input type="text" name="m_pw"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="탈퇴" onclick="return deleteRealy()">
		<input type="button" value="취소" onclick="goBack(3)">
	</td>
</tr>
</table>
</form>

</body>
</html>