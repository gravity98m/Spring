<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>itwill.jsp</h1>
	JSP(param) :	<%= request.getParameter("msg") %> <hr>
	JSP(attribure) :	<%= request.getAttribute("msg") %> <hr>
	<!--  request.getParameter("msg")는 jsp 내장객체이므로 전달가능 -->
	EL : ${msg} <hr>
	EL(r) : ${requestScope.msg} <hr>
	EL(s) : ${sessionScope.msg} <hr>
	EL(p) : ${pageScope.msg} <hr>
	EL(a) : ${applicationScope.msg} <hr>
	EL : ${param.msg} <hr>
	
	EL : ${param.tel} <hr>
	EL : ${tel} <hr>
	
	EL : ${msg} , ${tel}<hr>
	
	
	
</body>
</html>