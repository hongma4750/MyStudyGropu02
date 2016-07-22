/**
 * Join.jsp 안
 *	중복 검사 버튼 클릭시 사용 
 */


function idCheck(){
	if(document.frm.m_id.value==""){
		alert("아이디를 입력해 주세요");
		frm.m_id.focus();
		return;
	}
	
	var url="idCheck.do?m_id="+document.frm.m_id.value;
	window.open(url,"_black_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}