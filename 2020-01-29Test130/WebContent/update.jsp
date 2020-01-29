<%@page import="com.naver.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>회원수정</h1>
	<form action="updatego.do" method="post">
		아이디: <input readonly value="${dto.id}" name = "id"><br> 
		이름: <input value="${dto.name }"name="name"><br>
		나이: <input name="age" type = "number" value="${dto.age}"><br> 
		
		<input type="submit"value="회원수정"><br>
	</form>

	<%
	MemberDAO2 dao = new MemberDAO2();
	
	 
		
	%>


</body>
</html>