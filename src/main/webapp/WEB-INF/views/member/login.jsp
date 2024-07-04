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
			<h1>로그인 페이지</h1>
		</div>
		<div class="row">
			<form action="/member/login" method="post">
				<div class="mb-3">
					<label for="user_id" class="form-label">아이디</label>
					<input type="text" class="form-control" id="user_id" name="user_id" value="${id}">
				</div>
				<div class="mb-3">
					<label for="user_pw" class="form-label">패스워드</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw">
				</div>
				<div class="mb-3 form-check">
	    			<label class="form-check-label" for="exampleCheck1">아이디 기억하기</label>
	    			<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
	  			</div>
				
				<button type="submit" class="btn btn-primary">등록</button>
			</form>

		</div>

	</div>




<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>