<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>
<head>

</head>

<div class="container-fluid mt-3">
	<c:if test="${!empty postList }">
		<div class="card">
			<c:forEach var="post" items="${postList.content }">
				<div class="card-body">
					<h4 class="card-title">${post.title}</h4>
					<a href="/post/get/${post.id}" class="btn btn-secondary">상세 보기</a>
				</div>
			</c:forEach>
		</div>
		
		<br>
		<ul class="pagination justify-content-between">
			
			<li class="page-item <c:if test="${postList.first}">disabled</c:if>">
			<a class="page-link" href="?page=${postList.number - 1 }">이전페이지</a></li> <!-- number는 현재페이지를 가르킨다. -->
			<li class="page-item <c:if test="${postList.last}">disabled</c:if>">
			<a class="page-link" href="?page=${postList.number + 1 }">다음 페이지</a></li>
			<!-- 첫 페이지는 .first 마지막 페이지는 last  -->
			
		</ul>
		
	</c:if>


</div>
<%@ include file="./layout/footer.jsp"%>

</body>
</html>


