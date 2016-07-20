<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="Javascript/member.js"></script>

  
</head>
<body>

<h2>로그인</h2>

<form action="login.do" method="post" name="frm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="m_id" ></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="m_pw"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
				<input type="button" value="ID찾기" onclick="return idFind()">&nbsp;&nbsp;
				<input type="button" value="PW 찾기" onclick="pwFind()">&nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="location.href='join.do'">
			</td>
			
		</tr>
		
	</table>
</form>


</body>
</html>