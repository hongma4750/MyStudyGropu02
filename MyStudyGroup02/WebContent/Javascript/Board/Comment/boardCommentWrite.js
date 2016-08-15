/**
 * 내용 전송 
 */

function boardCommentWrite(){

	if($("#boardComment").val().length == 0){
		alert("댓글을 입력해 주세요");
		return false;
	}else{
	
		location.href="BoardServlet?command=board_comment_write&b_num="+$("#b_num").val()
		+"&m_id="+$("#m_id").val()
		+"&com_content="+$("#boardComment").val();
		return true;
	}
	
}