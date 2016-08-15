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
            return true;
        }
        return false;
});
	
	/* SNS/CommentUpdate.jsp?com_seq=${comment.com_seq }$r_seq=${comment.r_seq }&com_content= */
	//form 안의 수정하기 링크
	$('.modifying').click(function(e) {
		
	   var url="SNS/CommentUpdate.jsp?com_seq="+$('.com_seq_re').val()+"&r_seq="+$('.r_seq_re').val()+"&com_content="+$('.modify-comment-ta').val();
	    $(location).attr('href',url);
	     
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