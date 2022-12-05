<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>itwillMember.jsp</h1>
	
	${vo } <br>
	아이디 : ${vo.userid }<br>
	비밀번호 : ${vo.userpw }<br>
	<hr><hr>
	setAttribute(단일) (대문자 X ) : ${MemberVO } <hr>
	setAttribute(단일) (소문자 O)  : ${memberVO } <hr>
	
	<hr>
	${userid } <br>
</body>
</html>