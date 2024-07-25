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
					<h1>Product Detail</h1>
					<div class="mb-3">
						<label for="" class="form-label">Product Num</label>
						<input
							type="text" class="form-control" id="" name=""
							value="${requestScope.dto.product_num }" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Product Name</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${requestScope.dto.product_name }" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Product Rate</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${requestScope.dto.product_rate }" disabled>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Product Ex</label>
						<input type="text"
							class="form-control" id="" name=""
							value="${requestScope.dto.product_ex }" disabled>
					</div>

					<div>
						<c:forEach items="${dto.fileDTOs }" var="f">
							<a href="/resources/upload/products/${f.file_name }">${f.ori_name }</a>
						</c:forEach>
					</div>

					<a type="button" class="btn btn-primary" href="/account/add?product_num=${requestScope.dto.product_num }">상품가입</a>
					<a type="button" class="btn btn-danger" href="/product/delete?product_num=${requestScope.dto.product_num }">삭제</a>
					<a type="button" class="btn btn-warning" href="/product/update?product_num=${requestScope.dto.product_num }">수정</a>
					<a type="button" class="btn btn-primary" href="#" id="addWish" data-product-id="${dto.product_num}">위시 리스트 추가</a>

					<!-- 댓글  -->
					 <div>
						<!-- <textarea id="commentContents">

						</textarea>
						<button id="commentButton">상품평</button>

						 <div id="commentList"></div> -->

						 <!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#commentModal">
							상품평 입력
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Comment</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<textarea class="form-control" id="commentContents" rows="3"></textarea>
									</div>
								</div>
								<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal" id="commentClose">취소</button>
								<button type="button" class="btn btn-primary" data-id="${dto.product_num}" id="commentButton">저장</button>
								</div>
							</div>
							</div>
						</div>
						<div id="commentList">
							
						</div>
					 </div>


					<!-- 시작 -->

					<!-- 기본 끝 -->
				</div>
				<div id="wishResult">

				</div>
				<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
			</div>
			<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
		</div>
	</div>
	<script src="/resources/js/product/wish.js"></script>
	<script src="/resources/js/commons/comment.js"></script>
</body>
</html>