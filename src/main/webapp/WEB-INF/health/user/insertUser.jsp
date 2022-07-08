<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<br>
<div class="container-fluid mt-3">
	<form>
		<div class="mb-3">
			<label for="uname">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
		</div>
		<div class="mb-3">
			<label for="pwd">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>
		<div class="mb-3 mt-3">
			<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>
		<div class="mb-3 mt-3">
			<input type="radio"  id="gender" name="gender" value="female" checked="checked"><label for="female">Female</label><br>
			<input type="radio"  id="gender" name="gender" value="male" ><label for="male">Male</label><br> 
		</div>
		<div class="mb-3 mt-3">
			<select  id="purpose" name = "purpose" size="3">
				<option value ="diet">다이어트</option>
				<option value ="building">바디빌딩</option>
				<option value ="keep">유지</option>
			</select>
		</div>
	</form>

	<button id="btn-insert" class="btn btn-secondary">회원가입</button>

</div>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>
