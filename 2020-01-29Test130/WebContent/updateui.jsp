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

	<form action="update.do" method="post">
		<label for="id">수정 할 ID</label> 
		<input name="id"> <input
			type="submit" value="회원정보 확인.">
	</form>
	<%
		MemberDTO dto = (MemberDTO) request.getAttribute("dto");
		if (dto != null) {
	%>
	<%--             <%=dto.getId()%>:<%=dto.getName()%>:<%=dto.getAge()%> --%>
	${dto.id} | ${dto.name} | ${dto.age}
	<%
		}
	%>







	<h1>회원수정</h1>
	<form action="updatego.do" method="post">
		아이디: <input name="id"><br> 이름: <input name="name"><br>
		나이: <input name="age"><br> <input type="submit"
			value="회원수정"><br>
	</form>

</body>
</html>