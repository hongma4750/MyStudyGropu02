<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script src="Javascript/Member/updateCheck.js"></script>
<script src="Javascript/Member/deleteMember.js"></script>
<script src="Javascript/Member/goBack.js"></script>
</head>
<body>
<h2>회원 수정</h2>


<form action="memberUpdate.do" method="post" name="frm">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="m_name" size="20"value="${loginUser.m_name }" readonly></td>
		</tr>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" name="m_id" size="20" value="${loginUser.m_id }" readonly></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="m_pw" size="20" value="${loginUser.m_pw}"></td>
		</tr>
		
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="text" name="m_pwcheck" size="20"></td>
		</tr>
		
		<tr>
			<td>나이</td>
			<td><input type="text" name="m_age" size="20" value="${loginUser.m_age }"></td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="m_email" size="20" value="${loginUser.m_email }"></td>
		</tr>
		
		
		<tr>
			<td>핸드폰 번호</td>
			<td>
				<input type="text" name="m_phone1" size="3" value="${loginUser.m_phone1 }" maxlength="3">-
				<input type="text" name="m_phone2" size="4" value="${loginUser.m_phone2 }" maxlength="4">-
				<input type="text" name="m_phone3" size="4" value="${loginUser.m_phone3 }" maxlength="4">
			</td>	
		</tr>
		
		<tr>
			<td>성별</td>
			<td>
				<select name="m_gender">
					<option value="m" selected>남</option>
					<option value="w" >여</option>
				</select>
			</td>
		</tr>
		
		
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="확인" onclick="return updateCheck()">
				<input type="button" value="회원 탈퇴" onclick="deleteMember()">
				<input type="reset" value="취소" onclick="goBack(2)">
			</td>
		</tr>
	
	</table>
</form>
</body>
</html>