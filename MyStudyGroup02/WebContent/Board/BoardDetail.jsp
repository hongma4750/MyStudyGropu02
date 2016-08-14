<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Board.css">
<script type="text/javascript" src="Javascript/Board/moveBoardList.js"></script>
<script type="text/javascript" src="Javascript/Board/moveBoardWrite.js"></script>
</head>
<body>

<div id="wrap" align="center">
	<table>
		<tr>
			<th>작성자</th><td>${board.m_name }</td>
			<th>이메일</th><td>${board.m_email }</td>
		</tr>
		
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${board.b_writedate }"/></td>
			<th>조회수</th><td>${board.b_readcount }</td>
		</tr>
		<tr>
			<th>작성일</th><td colspan="3">${board.b_title }</td>
		</tr>
		
		<tr>
			<th>내용</th><td colspan="3"><pre>${board.b_content }</pre></td>
		</tr>
	</table>
	<br><br>

		<input type="button" value="게시글 수정" onclick="">
		<input type="button" value="게시글 삭제" onclick="">

		<input type="button" value="게시글 리스트" onclick="moveBoardList()">
		<input type="button" value="게시글 등록" onclick="moveBoardWrite()">
</div>

</body>
</html>