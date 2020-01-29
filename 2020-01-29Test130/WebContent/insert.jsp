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
	<h1>회원 가입</h1>
	
	
	<form action="insert.do" method="post">
		<!-- 	확장자명 이기에 "insert.do 로 사용 했다 ." -->
		<lable for="id">id:</lable>
		<input name="id" id="id"> <br>

		<lable for="name">name:</lable>
		<input name="name" id="name"> <br>

		<lable for="age">age:</lable>
		<input name="age" id="age" type="number"> <br> 
			<input type="submit" value="회원가입" onclick="alert('등록이완료되었습니다');">

	</form>
</body>
</html>