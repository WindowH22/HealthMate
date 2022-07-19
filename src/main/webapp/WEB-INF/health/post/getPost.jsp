<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<form>

		<div class="card">
			
			<div class="card-body">
				<h4 class="card-title">${post.title}</h4>
				<br>
				${post.content}
				<br>
				포스트 번호: <span id="id"><i>${post.id }</i></span>
				<br>
				작성자 : ${post.user.username }
				<hr>
				<!-- onclick="history.back()"이 동작하지않은 때 return false 를 적어주면 작동한다.  -->
				<button class="btn btn-secondary" onclick="history.back(); return false">돌아가기</button>
				<c:if test="${post.user.username == principal.username }">	
				<a href="/post/updatePost/${post.id}" class="btn btn-warning">수정하기</a>
				<button type="button" id="btn-delete" class="btn btn-danger">삭제하기</button> 
				
				</c:if>
			</div>
					
			
		</div>
	</form>

	
</div>
<script>
	$(document).ready(function() {
		$("#content").summernote({
			height : 300
		});
	});
</script>


<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>
