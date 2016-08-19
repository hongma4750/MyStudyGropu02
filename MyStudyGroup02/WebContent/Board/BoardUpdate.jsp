<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Board.css">
<script type="text/javascript" src="Javascript/Board/boardCheck"></script>
</head>
<body>

<div id="wrap" align="center">
	<form name="frm" method="post" action="BoardServlet">
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="b_num" value="${board.b_num }">
		<input type="hidden" name="b_ref" value="${board.b_ref }">
		<input type="hidden" name="b_step" value="${board.b_step }">
		<input type="hidden" name="b_depth" value="${board.b_depth }">
		
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" size="12" name="m_name" value="${board.m_name }"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" size="12" name="b_pass"></td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td><input type="text" size="40" maxlength="20" name="m_email" value="${board.m_email }"> </td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" size="70" name="b_title" value="${board.b_title }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea cols="70" rows="15" name="b_content">${board.b_content }</textarea></td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="등록" onclick="return boardCheck()">
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
	</form>
</div>

</body>
</html>