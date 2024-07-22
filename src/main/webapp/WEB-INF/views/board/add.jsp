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
				<!--  -->
				<div class="container">
					<h1>${board} Add</h1>
					<form method="post" enctype="multipart/form-data">
					<input type="hidden" value="${requestScope.dto.board_num}" name="board_num">
						<div class="mb-3">
							<label for="board_writer" class="form-label">작성자</label>
							<input type="text" readonly class="form-control" id="board_writer" name="board_writer" value="${sessionScope.dto.user_id }">
						</div>
						<div class="mb-3">
							<label for="board_title" class="form-label">제목</label>
							<input type="text" class="form-control" id="board_title" name="board_title" value="${requestScope.dto.board_title}">
						</div>
						<div class="mb-3">
							<label for="board_contents" class="form-label">본문</label>
							<textarea rows="5" class="form-control" id="board_contents" name="board_contents">
								${requestScope.dto.board_contents }
							</textarea>
						</div>
						
						<div class="mb-3">
							<button type="button" id="add" class = "btn btn-primary">파일 추가</button>
						</div>
						<div id="result">
						</div>
						
						
						<button type="submit" class="btn btn-primary">등록</button>
						<a href="./list" class = "btn btn-danger">취소</a>
					</form>
		
				</div>
				
				<!--  -->
				<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
			</div>
			<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
		</div>
	</div>
	
	<script src="/resources/js/commons/files.js"></script>
	<script>
		setMax(5);
	</script>
</body>
</html>