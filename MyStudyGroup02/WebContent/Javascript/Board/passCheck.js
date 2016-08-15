/**
 * 비밀번호 체크 시 사용됨
 */

function passCheck(){
	if(document.frm.b_pass.value.length==0){
		alert("비밀번호를 입력해 주세요");
		return false;
	}
	
	return true;
}