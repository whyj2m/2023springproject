<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 이름으로 검색</h2>
<a href="/"> 홈으로 </a>  <br> <hr>
아이디 : ${member.id }   <hr> <br>
	아이디 : ${member.name } <hr> <br>
	아이디 : ${member.email } <hr> <br>
</body>
</html>