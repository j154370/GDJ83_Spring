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
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<div class="container">


					<table class="table table-hover">
						<thead>
							<tr>
								<th>글번호</th>
								<th>작성자</th>
								<th>내용</th>
								<th>작성일</th>
								<th>상품 번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="comment">
								<tr>
									<td>${comment.board_num}</td>
									<td>${comment.board_writer}</td>
									<td>${comment.board_contents}</td>
									<td>${comment.create_date}</td>
									<td>${comment.product_num}</td>
									<td>
										<c:if test="${comment.board_writer eq dto.user_id}">
											<button type="button" class="del" data-del-id="${comment.board_num}">X</button>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link pn"
								data-page-num="${pager.startNum - 1 }"
								href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>

							<c:forEach begin="${pager.startNum }" end="${pager.lastNum }"
								step="1" var="i">
								<li class="page-item"><a class="page-link pn"
									data-page-num="${i}"
									href="#">${i}</a></li>
							</c:forEach>	

							<li class="page-item ${pager.next?'':'disabled' }"><a
								class="page-link pn"
								data-page-num="${pager.lastNum + 1 }"
								href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>


				</div>
			</div>
		</div>
		</div>
</body>
</html>