<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Board.css">
<script type="text/javascript" src="Javascript/Board/boardCheck.js"></script>
<script type="text/javascript" src="Javascript/Board/moveBoardList.js"></script>
</head>
<body>

<div id="wrap" align="center">
<h1>게시글 등록</h1>
<form action="BoardServlet" method="post" name="frm">
	<input type="hidden" name="command" value="board_write_af">
	
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="m_name"></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="b_pass"></td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="m_email"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="b_title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="15" cols="70" name="b_content"></textarea></td>
		</tr>
	</table>
	<br><br>
	<input type="submit" value="등록" onclick="return boardCheck()">
	<input type="reset" value="다시작성">
	<input type="button" value="목록" onclick="moveBoardList()">
</form>

</div>

</body>
</html>