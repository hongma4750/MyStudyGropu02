<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디찾기</title>
<script type="text/javascript" src="Javascript/member.js"></script>
</head>
<body>
<h2>아이디 찾기</h2>

<form action="Idfind.do" method="post" name="frm">
<table border="1">

<tr>
	<td>이름</td>
	<td><input type="text" name="m_id" size=20></td>
</tr>

<tr>
	<td>이메일</td>
	<td><input type="text" name="m_email" size=50></td>
</tr>

<tr>
	<td colspan="2">
		<input type ="submit" value="ID찾기" onclick="return idFindCheck()">
		<input type="button" value="돌아가기" onclick="location.href='index.jsp?mode=Body'">
	</td>
	
</tr>

<c:if test="${memberdto != null}">
	<tr>
		<td colspan="2">${memberdto.getM_id()}입니다.</td>
	</tr>
</c:if>

<c:if test="${memberdto == null}">
	<tr>
		<td colspan="2">해당하는 정보의 회원은 없습니다.</td>
	</tr>
</c:if>

</table>
</form>
</body>
</html>