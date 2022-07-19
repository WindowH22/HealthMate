<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<form>
		<!-- hidden값으로 ID를 준다. -->
		<input type="hidden" name="id" id="id" value="${post.id}"/> 
		
		<div class="mb-3">
			<label for="title">Title:</label> <input type="text" class="form-control" id="title" name="title" value="${post.title}">
		</div>
		<div class="mb-3">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="content" name="content">
			${post.content}
			</textarea>
		</div>
		<div>
			<button class="btn btn-secondary" onclick="history.back(); return false">돌아가기</button>
			<button type="button" id="btn-update"  class="btn btn-warning">수정완료</button>
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
