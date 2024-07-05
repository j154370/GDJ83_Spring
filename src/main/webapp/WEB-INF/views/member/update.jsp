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
			<h1>회원 정보 수정 페이지</h1>
		</div>
		<div class="row">
			<form action="/member/update" method="post">
				<input type="hidden" name="user_id" value="${sessionScope.dto.user_id }">
				
				<div class="mb-3">
					<label for="user_phone" class="form-label">전화번호</label>
					<input type="text" class="form-control" id="user_phone" name="user_phone" value="${sessionScope.dto.user_phone }">
				</div>
				<div class="mb-3">
					<label for="user_email" class="form-label">이메일</label>
					<input type="text" class="form-control" id="user_email" name="user_email" value="${sessionScope.dto.user_email }">
				</div>
				<div class="mb-3">
					<label for="user_address" class="form-label">주소</label>
					<input type="text" class="form-control" id="user_address" name="user_address" value="${sessionScope.dto.user_address }">
				</div>
				<div class="mb-3">
					<label for="user_name" class="form-label">이름</label>
					<input type="text" class="form-control" id="user_name" name="user_name" value="${sessionScope.dto.user_name }">
				</div>
				
				<button type="submit" class="btn btn-primary">수정</button>
			</form>

		</div>

	</div>



<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>