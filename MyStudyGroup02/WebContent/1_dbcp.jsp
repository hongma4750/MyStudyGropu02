<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="javax.naming.InitialContext" %>
    <%@ page import="javax.naming.Context" %>
    <%@ page import="javax.sql.DataSource" %>
    <%@ page import="com.hongma.Member.BEAN.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h4>디비연동</h4>

<%-- <%

Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
Connection conn = ds.getConnection();
out.println("디비 연결 성공");
//etc. %> --%>

<%
MemberDAO memberdao = MemberDAO.getInstance();
Connection conn = memberdao.getConnection();
out.println("연결성공");
%>
</body>
</html>