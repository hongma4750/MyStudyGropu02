<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="Javascript/member.js"></script>
</head>
<body>



<form action="join.do" method="post" name="frm">
	<table>
	
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="m_name"></td>	
		</tr>
		
		<tr>
			<td>ID</td>
			<td>
				<input type="text" name="m_id">
				<input type="hidden" name="reid" >
				<input type="button" value="중복체크" onclick="idCheck()">
			</td>
					
		</tr>
	
		<tr>
			<td>PW</td>
			<td><input type="password" name="m_pw"></td>	
		</tr>
		
		<tr>
			<td>암호 확인</td>
			<td><input type="password" name="m_pwcheck"></td>	
		</tr>

		<tr>
			<td>나이</td>
			<td><input type="text" name="m_age"></td>	
		</tr>
		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="m_email"></td>	
		</tr>
		
		<tr>
			<td>핸드폰 번호</td>
			<td>
				<input type="text" name="m_phone1" size="3" maxlength="3">-
				<input type="text" name="m_phone2" size="4" maxlength="4">-
				<input type="text" name="m_phone3" size="4" maxlength="4">
			</td>	
		</tr>
		
		<tr>
			<td>성별</td>
			<td>
				<select name="m_gender">
					<option value="m" selected >남</option>
					<option value="w">여</option>
				</select>
			</td>	
		</tr>
		
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장" onclick="return joinCheck()">
				<input type="reset" value="리셋">
				<input type="button" value="취소" onclick="javascript:history.back(-1)">
			</td>
		</tr>
		
		
		
	</table>

</form>
</body>
</html>