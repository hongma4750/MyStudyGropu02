/**
 * 댓글 폼, 수정시 들어내기
 */

$(document).ready(function() {

	$('.comment-toggle').click(function(e) {
		
	        var $form = $(e.target).parent().parent().find('.modify-comment');

	        var $p = $(e.target).parent().parent().find('.comment-toggle');
	        var $o = $(e.target).parent().parent().find('.comment-delete');
	        var $c = $(e.target).parent().parent().parent().find('.comment-content');
      
	        if ($form.is(':hidden') == true) {
	            $form.show();
	            $p.hide();
	        	$o.hide();
	        	$c.hide();
	        } else {
	            $form.hide();
	            $p.show();
	            $o.show();
	            $c.show();
	        }
	        return false;
	});
	
	$('.comment-delete').click(function(e) {
		var chk = confirm("정말로 삭제하시겠습니까?");
        if (chk == true) {
        	var com_seq = $(e.target).parent().parent().parent().find(".com_seq").val();
        	var b_num = $(e.target).parent().parent().parent().find(".b_num").val();
        	var url = "BoardServlet?command=board_comment_delete&com_seq="+com_seq+"&b_num="+b_num;
        	$(location).attr("href",url);
            return true;
        }
        return false;
});
	
	
	//form 안의 수정하기 링크
	$('.modifying').click(function(e) {
		
	   /*var url="SNS/CommentUpdate.jsp?com_seq="+$('.com_seq_re').val()+"&r_seq="+$('.r_seq_re').val()+"&com_content="+$('.modify-comment-ta').val();
	    $(location).attr('href',url);
	    
	    $("#frmFrom").attr("action","_self").attr()*/
		
		
		var com_seq = $(e.target).parent().parent().parent().find(".com_seq").val();
		var com_ref = $(e.target).parent().parent().parent().find(".com_ref").val();
		var com_step = $(e.target).parent().parent().parent().find(".com_step").val();
		var com_depth = $(e.target).parent().parent().parent().find(".com_depth").val();
		var com_content = $(e.target).parent().parent().parent().find(".modify-comment-ta").val();
		var b_num = $(e.target).parent().parent().parent().find(".b_num").val();
		var url = "BoardServlet?command=board_comment_update&com_seq="+com_seq+"&com_ref="+com_ref+"&com_step="+com_step
					+"&com_depth="+com_depth+"&com_content="+com_content+"&b_num="+b_num;
		$(location).attr("href",url);
		
		
	    /*$("#frmFrom").attr({action:'aaaa.jsp', method:'get'}).submit();*/
	    
		
		
		//alert(url);
	    //location.href="index01.jsp?mode=SNS/ReviewDetail"

	});
	
	//form 안의 취소 링크
	$('.cancel').click(function(e) {
	    var $form = $(e.target).parent().parent().parent().parent().find('.modify-comment');
	    
	    var $p = $(e.target).parents().find('.comment-toggle');
        var $o = $(e.target).parents().find('.comment-delete');
        var $c = $(e.target).parents().find('.comment-content');
        
        
        /* alert("1 : "+$('#com_seq_check').attr('value'));
        alert("2 : "+$(e.target).parents().find('.cancel').attr('id')); */
        
	    if ($form.is(':hidden') == true) {
	    	$form.show();
	        $p.hide();
        	$o.hide();
        	$c.hide();
	    } else {
	    	
	    	$form.hide();
	        $p.show();
            $o.show();
            $c.show();
	    }
	    return false;
	});

});