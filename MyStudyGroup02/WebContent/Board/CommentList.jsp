<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<script type="text/javascript" src="../Javascript/Board/Comment/boardComment.js"></script>


<!-- 댓글 -->
	
			<c:forEach var="comment" items="${comList }">
				
				<c:choose>
					<c:when test="${comment.com_del ==1 }">
						<tr style="background-color:#d3d3d3">
							<td colspan="4">삭제된 댓글 입니다.[임시방편]</td>
						</tr>
					</c:when>
					
					<c:otherwise>
							<tr style="background-color:#d3d3d3">
						<td colspan="4">
						
							<div class="comments">
	
							<h4 class="view-commnet"> 
								[${comment.m_id}] 
								<small>${comment.com_writedate }</small>
								<c:if test="${loginUser.m_id == comment.m_id }">		
										<a href="#" ><small class="comment-toggle">수정</small></a>
										<a href="#"><small class="comment-delete">삭제</small></a>
										<a href="#"><small class="comment-comment">답글</small></a>
	
									<!--  댓글 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!jquery -->	
												
									<div class="modify-comment" style="display: none">
								    	
								    <div style="text-align: right;">
								      <a href="#"><small class="modifying" >수정</small></a> |
								      <a href="#"><small class="cancel" >취소</small></a>
								    </div>
								    
								    <div>
								    	<input type="hidden" value="${comment.com_seq }"class="com_seq">
								    	<input type="hidden" value="${comment.com_ref }"class="com_ref">
								    	<input type="hidden" value="${comment.com_step }" class="com_step">
								    	<input type="hidden" value="${comment.com_depth }" class="com_depth">
								    	<input type="hidden" value="${comment.b_num }" class="b_num">
								      <textarea class="modify-comment-ta" name="com_contents" rows="5" cols="50">${comment.com_content }</textarea>
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
					</c:otherwise>
				</c:choose>
				
				
			</c:forEach>


