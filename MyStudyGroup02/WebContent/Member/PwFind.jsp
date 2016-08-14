<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>비밀번호 찾기</h2>

<form action="pwfind.do" method="post" name="frm">
<table border="1">

<tr>
	<td>이름</td>
	<td><input type="text" name="m_name" size=20></td>
</tr>
<tr>
	<td>아이디</td>
	<td><input type="text" name="m_id" size=20></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="m_email" size=50></td>
</tr>

<tr>
	<td colspan="2">
		<input type ="submit" value="비밀번호" onclick="return idFindCheck()">
		<input type="button" value="돌아가기" onclick="location.href='index.jsp?mode=Body'">
	</td>
	
</tr>

</table>
</form>

</body>
</html>