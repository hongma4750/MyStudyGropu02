/**
 * 
 * Join.jsp 안
 * 
 * 회원 가입 버튼 눌렀을때
 * 
 * input type 안 모두 적었는지 체크
 * 중복 검사 체크
 * 아이디 틀렸는지 체크
 * 비밀번호 같은지 체크
 */
 
function joinCheck(){
	if(document.frm.m_name.value.length==0){
		
		alert("이름을 입력해 주세요");
		frm.m_name.focus();
		
		return false;
		
	}else if(document.frm.m_id.value.length==0){
		alert("아이디를 입력해 주세요");
		frm.m_id.focus();
		return false;
	}else if(document.frm.m_pw.value.length==0){
		alert("비밀 번호를 입력해 주세요");
		frm.m_pw.focus();
		return false;
	}else if(document.frm.m_pw.value != document.frm.m_pwcheck.value){
		alert("암호가 일치하지 않습니다.");
		frm.m_pwcheck.focus();
		return false;
	}else if(document.frm.m_age.value.length==0){
		alert("나이를 입력해 주세요");
		frm.m_age.focus();
		return false;
	}else if(document.frm.m_email.value.length==0){
		alert("이메일을 입력해 주세요");
		frm.m_email.focus();
		return false;
	}else if(document.frm.m_phone1.value.length==0){
		alert("핸드폰 번호를 입력해주세요");
		frm.m_phone1.focus();
		return false;
	}else if(document.frm.m_phone2.value.length==0){
		alert("핸드폰 번호를 입력해주세요");
		frm.m_phone2.focus();
		return false;
	}
	else if(document.frm.m_phone3.value.length==0){
		alert("핸드폰 번호를 입력해주세요");
		frm.m_phone3.focus();
		return false;
	}
	else if(document.frm.reid.value.length==0){
		alert("중복검사를 하지 않았습니다.");
		frm.m_id.focus();
		return false;
	}else if(document.frm.reid.value != document.frm.m_id.value){
		alert("아이디 중복검사를 다시 실시해 주세요");
		frm.m_id.focus();
		return false;
	}
	return true;
}