<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>
				<!-- 기본 시작 -->
				<div class="container">
					<div class="row">
						<h1>회원 정보 입력 페이지</h1>
					</div>
					<div class="row">
						<form action="/member/join" method="post" id="frm">
							<div class="mb-3">
								<label for="user_id" class="form-label">아이디</label> <input
									type="text" class="form-control" id="user_id" name="user_id">
							</div>
							<div class="mb-3" id="divMouse1">
								<label for="user_pw" class="form-label">패스워드</label> <input
									type="password" class="form-control" id="user_pw"
									name="user_pw">
								<div id="password_error" class="text-danger"></div>
							</div>
							<div class="mb-3" id="divMouse2">
								<label for="user_pw" class="form-label">패스워드 검증</label> <input
									type="password" class="form-control" id="user_pw_check">
								<div id="password_eqerror" class="text-danger"></div>
							</div>
							<div class="mb-3">
								<label for="user_name" class="form-label">이름</label> <input
									type="text" class="form-control" id="user_name"
									name="user_name">
							</div>
							<div class="mb-3">
								<label for="user_phone" class="form-label">전화번호</label> <input
									type="text" class="form-control" id="user_phone"
									name="user_phone">
							</div>
							<div class="mb-3">
								<label for="user_email" class="form-label">이메일</label> <input
									type="text" class="form-control" id="user_email"
									name="user_email">
							</div>
							<div class="mb-3">
								<label for="user_address" class="form-label">주소</label> <input
									type="text" class="form-control" id="user_address"
									name="user_address">
							</div>

							<div class="mb-3">
								<button id = "add" type="button" class="btn btn-primary">사진파일 추가</button>
							</div>
							<div class = "mb-3" id="result">

							</div>

							<div class="mb-3">
								<button id = "btn" type="button" class="btn btn-primary">회원가입</button>
							</div>
						</form>

					</div>

				</div>

				<!-- 기본 끝 -->
			</div>
			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
		<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
		<script type="text/javascript"
			src="/resources/js/member/memberJoinCheck.js"></script>
		<script type="text/javascript"
			src="/resources/js/commons/files.js"></script>
	</div>
</body>
</html>