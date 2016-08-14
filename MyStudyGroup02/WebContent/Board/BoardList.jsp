<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<script src="Javascript/Board/moveBoardWrite.js"></script>
<link rel="stylesheet" type="text/css" href="css/Board.css">

</head>
<body>
<div id="wrap">
<h1>게시판 리스트</h1>

<table class="list">


<tr>
	<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th>
</tr>

<c:forEach var="board" items="${boardList }">
	<tr class="record">
		<td>${board.b_num }</td>
		<td>
			<a href="BoardServlet?command=board_detail&b_num=${board.b_num }">${board.b_title }</a>
		</td>
		<td>${board.m_name }</td>
		<td><fmt:formatDate value="${board.b_writedate }"/></td>
		<td>${board.b_readcount }</td>
	</tr>
</c:forEach>
</table>
<input type="button" value="글쓰기" onclick="moveBoardWrite()">
</div>


<hr>
</body>
</html>