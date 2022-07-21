<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<form action="/auth/login" method="post">
		<div class="mb-3">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" name="username" 
			placeholder="Enter username">
		</div>
		<div class="mb-3">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" name="password" 
			placeholder="Enter password">
		</div>
		<button id="btn-login" class="btn btn-secondary">로그인</button>
	</form>
	
	
</div>
<%@ include file="../layout/footer.jsp"%>
