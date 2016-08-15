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
<script type="text/javascript" src="Javascript/Board/open_win.js"></script>
<script type="text/javascript" src="Javascript/Board/moveBoardAnswer.js"></script>
<script type="text/javascript" src="Javascript/Board/Comment/boardComment.js"></script>
<script type="text/javascript" src="Javascript/Board/Comment/boardCommentWrite.js"></script>
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
		
		<c:if test="${comList.size() == 0}">
			<tr >
				<td colspan="4" style="background-color:#d3d3d3">등록된 댓글이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${comList.size() > 0}">
			<jsp:include page="../Board/CommentList.jsp" flush="false"/>
		</c:if>
		
		<tr>
			<td colspan="4">
				<div>
					<input type="hidden" id="b_num" value="${board.b_num }">
					<input type="hidden" id="m_id" value="${loginUser.m_id }">
					<textarea cols="15" rows="20" name="com_content" id="boardComment"></textarea> 
					<input type="button" value="저장" id="boardButton" onclick="boardCommentWrite()">
				</div>
			</td>
		</tr>
		
		
	</table>
	<br><br>
		
		<c:choose>
			<c:when test="${loginUser.m_id eq board.m_id }">
				<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&b_num=${board.b_num}','update')">
				<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&b_num=${board.b_num}','delete')">
			</c:when>
		</c:choose>
		<c:if test="${loginUser ne null }">
			<input type="button" value="답글" onclick="location.href='BoardServlet?command=board_answer&b_num=${board.b_num}'">
			<input type="button" value="게시글 등록" onclick="moveBoardWrite()">
		</c:if>
		
		<input type="button" value="게시글 리스트" onclick="moveBoardList()">
		
</div>

</body>
</html>