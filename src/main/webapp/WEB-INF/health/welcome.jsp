<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>
<head>

</head>

<div class="container-fluid mt-3">
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">헬스메이트 메인화면입니다.</h4>
			${principal.username }님 환영합니다.
			<a href="#" class="btn btn-secondary">상세 보기</a>
		</div>
	</div>
</div>
<%@ include file="./layout/footer.jsp"%>

</body>
</html>


