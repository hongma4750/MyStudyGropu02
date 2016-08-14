/**
 * BoardWrite 에서 모든 폼 다 입력 받았는지 체크
 */
 

function boardCheck(){
	if(document.frm.m_name.value.length==0){
		alert("작성자를 입력하시오");
		return false;
	}
	if(document.frm.b_pass.value.length==0){
		alert("비밀번호를 입력하시오");
		return false;
	}
	if(document.frm.b_title.value.length==0){
		alert("제목을 입력하시오");
		return false;
	}
}