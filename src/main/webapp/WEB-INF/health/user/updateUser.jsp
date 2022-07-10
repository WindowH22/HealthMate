<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mb-3 mt-3">username: ${principal.username }</div>
	<div class="mb-3 mt-3">email:${principal.email }</div>
	<div class="mb-3 mt-3">gender:${principal.gender }</div>
	<div class="mb-3 mt-3">purpose:${principal.purpose }</div>




</body>
</html>