/**
 *	Member/MemberUpdate.jsp 안에서 사용됨
 *
 *	수정시 공백 , 비밀번호 같은지 검사
 *
 */


function updateCheck(){
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
	
	return true;
}


