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
	<form action="delete.do" method="post">
		ID:<input name="id"><br>
		  <input type="submit" value="회원삭제" onclick="alert('삭제가완료되었습니다');">
		   `
	</form>
	<%
	
	%>
<%-- 	<% --%>
<!-- // 		MemberDAO2 dao = new MemberDAO2(); -->
<!-- // 		dao.delete("id"); -->
<%-- 	%> --%>
</body>
</html>