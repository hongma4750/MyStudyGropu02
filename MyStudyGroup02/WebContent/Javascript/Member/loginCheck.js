/**
 * Member/Login.jsp 안
 * 
 * 아이디 와 비밀번호 공백 있는지 검사
 */ 

function loginCheck(){
	if(document.frm.m_id.value.length==0){
		alert("아이디를 입력해주세요");
		frm.m_id.focus();
		return false;
	}else if(document.frm.m_pw.value.length==0){
		alert("비밀번호를 입력해 주세요");
		frm.m_pw.focus();
		return false;
	}
	return true;
}