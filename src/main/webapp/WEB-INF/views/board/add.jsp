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
			<h1>${board } 게시글 작성</h1>
		</div>
		
		<div class="row">
			<form method="post">
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
				
				
				<button type="submit" class="btn btn-primary">등록</button>
			</form>

		</div>

	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>