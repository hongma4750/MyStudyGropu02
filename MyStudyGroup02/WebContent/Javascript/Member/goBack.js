/**
 *		Member 폴더 안에서 뒤로 이동 시 모두 사용
 *
 * 		뒤로만 이동함
 * 
 */ 

function goBack(a){
	if(a==1){
		location.href="login.do";
	}else if(a==2){
		location.href="index.jsp?mode=Body";
	}else if(a==3){
		location.href="memberUpdate.do";
	}
}