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
		<label for="id">���� �� ID</label> 
		<input name="id"> <input
			type="submit" value="ȸ������ Ȯ��.">
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







	<h1>ȸ������</h1>
	<form action="updatego.do" method="post">
		���̵�: <input name="id"><br> �̸�: <input name="name"><br>
		����: <input name="age"><br> <input type="submit"
			value="ȸ������"><br>
	</form>

</body>
</html>