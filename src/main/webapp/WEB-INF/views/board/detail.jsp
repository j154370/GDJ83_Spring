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
					<h1>${board} Detail</h1>
					<div class="mb-3">
						<label for="" class="form-label">번호</label>
						<input
							type="text" class="form-control" id="" name=""
							value="${dto.board_num }" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">카테고리</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.board_category}" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">제목</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.board_title}" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">작성자</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.board_writer}" disabled>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">작성일</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.create_date}" disabled>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">수정일</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.update_date}" disabled>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">조회수</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.board_hit}" disabled>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">내용</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${dto.board_contents}" disabled>
					</div>
					
					<div>
						<c:forEach items="${dto.boardFileDTOs }" var="f">
							<a href="/resources/upload/${board }/${f.file_name }">${f.ori_name }</a>
						</c:forEach>
					</div>


<%-- 					<a type="button" class="btn btn-primary" href="/account/add?product_num=${requestScope.dto.product_num }">상품가입</a>
					<a type="button" class="btn btn-danger" href="/product/delete?product_num=${requestScope.dto.product_num }">삭제</a>
					<a type="button" class="btn btn-warning" href="/product/update?product_num=${requestScope.dto.product_num }">수정</a> --%>
	
					<div>
						<c:if test="${board ne 'Notice' }">
							<a type="button" class="btn btn-primary" href="./reply?board_num=${dto.board_num }">답글</a>		
						</c:if>
						<c:if test="${sessionScope.dto.user_id eq dto.board_writer}">
						<a type="button" class="btn btn-danger" href="./delete?board_num=${dto.board_num }">삭제</a>
						<a type="button" class="btn btn-warning" href="./update?board_num=${dto.board_num }">수정</a>			
						</c:if>
					</div>

					<!-- 시작 -->

					<!-- 기본 끝 -->
				</div>
				<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
			</div>
			<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
		</div>
	</div>
</body>
</html>