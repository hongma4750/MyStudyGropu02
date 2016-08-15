<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/Board.css">
<script type="text/javascript" src="../Javascript/Board/passCheck"></script>
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<form action="BoardServlet" name="frm" method="get">
		<input type="hidden" name="command" value="board_check_pass">
		<input type="hidden" name="b_num" value="${param.b_num }">
		<table style="width:80%">
			<tr>
				<th>비밀번호</th>
				
				<td><input type="password" name="b_pass" size="20"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="확인" onclick="return passCheck()">
	</form>
</div>

</body>
</html>