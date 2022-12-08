<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/list.jsp</h1>
	
	<%-- ${memberList } --%>
	<table border="1">
		<tr>
			<th>아이디</th>		
			<th>이름</th>		
			<th>이메일</th>		
			<th>회원가입일</th>		
			<th>회원정보수정일</th>		
		</tr>
		<c:forEach var="vo" items="${memberList }">
		<tr>
			<td>${vo.userid}</td>		
			<td>${vo.username}</td>		
			<td>${vo.useremail}</td>		
			<td>${vo.regdate}</td>		
			<td>${vo.updatedate}</td>		
		</tr>
		</c:forEach>
	</table>
	
	<a href="/member/main"> 메인페이지로... </a>
</body>
</html>