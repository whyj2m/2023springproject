<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/"> 홈으로 </a>  <br> <hr>
	
	<a href="/insert"> 멤버등록 </a> <br><p></p> <hr>
	<a href="/selectAll"> 전체조회 </a> <br><p></p>  <hr>
	<a href="/selectId?id=102"> 아이디로 조회 </a> <br><p></p>  <hr>
	<a href=/selectByEmail?email=whyjm@gmail.com>이메일 조회 </a> <br><p></p>  <hr>
	<a href="/selectByName?name=제이엠"> 이름으로 조회 </a> <br><p></p>  <hr>
	<a href=/selectByNameLike?name=제>리스트 조회 - Name Like</a> <br><p>
	<a href=/selectByNameLikeNameDesc?name=제>리스트 조회 - Name Like Name 역순 </a> <br><p>
	<!-- <a href=/selectNameSort?name=제>리스트 조회 - Name Like Sort  오름차순 </a> <br><p> -->
<hr>
</body>
</html>