/**
 * 
 * 
 * boardServlet 으로 이동할때 사용됨
 */

function boardMove(command){
	alert("작동");
	location.href="BoardServlet?command="+command;
}