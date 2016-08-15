<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../Javascript/Board/Comment/boardComment.js"></script>
</head>
<body>

<!-- 댓글 -->
		
		
		
			<c:forEach var="comment" items="${comList }">
				<tr style="background-color:#d3d3d3">
					<td colspan="4">
					
						<div class="comments">

						<h4 class="view-commnet"> 
							[${comment.m_id}] 
							<small>${comment.com_writedate }</small>
							<c:if test="${loginUser.m_id == comment.m_id }">		
									<a href="#" ><small class="comment-toggle">수정</small></a>
									<a href="<%-- SNS/CommentDelete.jsp?com_seq=${comment.com_seq }&r_seq=${comment.r_seq} --%>#"><small class="comment-delete">삭제</small></a>
	
	
								<!--  댓글 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!jquery -->	
											
								<div class="modify-comment" style="display: none">
							    	
							    <div style="text-align: right;">
							      <a href="#"><small class="modifying">수정</small></a> |
							      <a href="#"><small class="cancel" id="${comment.com_seq }">취소</small></a>
							    </div>
							    
							    <div>
							    	<input type="hidden" value="${comment.com_seq }" class="com_seq_re" id="com_seq_check">
							    	<%-- <input type="hidden" value="${comment.r_seq }" class="r_seq_re" > --%>
							      <textarea class="modify-comment-ta" name="com_content_re" rows="4" cols="50">${comment.com_content }</textarea>
							    </div>
							    
							  </div>
									
							</c:if>
						</h4>
						<h3 class="comment-content">
						${comment.com_content } 
						</h3>
						</div>
					</td>
				</tr>
			</c:forEach>

		
		

</body>
</html>