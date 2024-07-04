<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	
	<div class="container">
		<div class="row">
			<h1>회원 정보 입력 페이지</h1>
		</div>
		<div class="row">
			<form action="/member/join" method="post">
				<div class="mb-3">
					<label for="user_id" class="form-label">아이디</label>
					<input type="text" class="form-control" id="user_id" name="user_id">
				</div>
				<div class="mb-3">
					<label for="user_pw" class="form-label">패스워드</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw">
				</div>
				<div class="mb-3">
					<label for="user_name" class="form-label">이름</label>
					<input type="text" class="form-control" id="user_name" name="user_name">
				</div>
				<div class="mb-3">
					<label for="user_phone" class="form-label">전화번호</label>
					<input type="text" class="form-control" id="user_phone" name="user_phone">
				</div>
				<div class="mb-3">
					<label for="user_email" class="form-label">이메일</label>
					<input type="text" class="form-control" id="user_email" name="user_email">
				</div>
				<div class="mb-3">
					<label for="user_address" class="form-label">주소</label>
					<input type="text" class="form-control" id="user_address" name="user_address">
				</div>
				
				<button type="submit" class="btn btn-primary">등록</button>
			</form>

		</div>

	</div>
	
	
	
	
	
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>