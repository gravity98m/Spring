<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bank_main.jsp</h1>
<h1>인증완료(토큰발급)</h1>
<h2>access_token : ${responseTokenVO.access_token }</h2>
<h2>token_type : ${responseTokenVO.token_type }</h2>
<h2>expires_in : ${responseTokenVO.expires_in }</h2>
<h2>refresh_token : ${responseTokenVO.refresh_token }</h2>
<h2>scope : ${responseTokenVO.scope }</h2>
<h2>user_seq_no : ${responseTokenVO.user_seq_no }</h2>

<h2>사용자정보 조회</h2>
<h2>등록계좌조회</h2>
</body>
</html>