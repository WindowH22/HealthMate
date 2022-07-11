<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mx-auto" style="margin-top: 20px; width: 200px;"><h2>회원 상세보기</h2></div>
	
	<div class="grid">
		<div class="p-3 mb-2 bg-light">
			username:<span class="ms-2">${principal.username }</span>
		</div>

		<div class="p-3 mb-2 bg-light">
			email:<span class="ms-2">${principal.email }</span>
		</div>

		<div class="p-3 mb-2 bg-light">
			gender:<span class="ms-2">${principal.gender }</span>
		</div>

		<div class="p-3 mb-2 bg-light">
			purpose:<span class="ms-2">${principal.purpose }</span>
		</div>
	</div>



</body>
</html>