<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
<form>
<div>작성자 : ${findPost.user.username }</div>

<div class="mb-3">
	<label for="title">Title:</label> 
	<div>${findPost.title}</div>
</div>
<div class="mb-3">
	<label for="content">Content:</label> 
	<p>${findPost.content} </p>
</div>
</form>

<button id="btn-insert" class="btn btn-secondary">포스트수정</button>
</div>
<script>
$(document).ready(function () {
    $("#content").summernote({
        height: 300
    });
});
</script>


<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>
