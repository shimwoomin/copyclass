<%@page import="com.naver.MemberDTO"%>
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
	<h1>회원 목록</h1>

	<%-- 	<%	 --%>
	<!-- // 		Object obj4 = request.getAttribute("dto"); -->
	<!-- // 		MemberDTO dto = null; -->
	<!-- // 		if(obj4 != null){ -->
	<!-- // 			dto = (MemberDTO)obj4; -->
	<!-- // 			String id = dto.getId(); -->
	<!-- // 			String name = dto.getName(); -->
	<!-- // 			int age = dto.getAge();	 -->
	<%-- 		}	%> --%>

	<%-- 			ID:<%= dto.getId()%> --%>
	<!-- 			<br> -->
	<%-- 			NAME:<%= dto.getName()%> --%>
	<!-- 			<br> -->
	<%-- 			AGE:<%= dto.getAge()%>: --%>


	ID: ${dto.id }
	<br> NAME: ${dto["name"]}
	<br> age : ${dto.age}
	<br>

	<a href="updateui.do?id=${dto.id}">수정</a>
	<a href="list.do">목록</a>
	<a href="delete.do?id=${dto.id}" onclick="alert('삭제가완료되었습니다');">삭제</a>
	
</body>
</html>