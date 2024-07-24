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
				<div class="container">
					<h1>WISH LIST</h1>
					<form action="/product/list" method="get"
						class="row row-cols-lg-auto g-3 align-items-center">


						<div class="input-group">
							<select name="kind" class="form-select" id="inlineFormSelectPref">
								<option value="k1">상품명</option>
								<option value="k2">상품 내용</option>
							</select> <input type="text" name="search" class="form-control"
								id="inlineFormInputGroupUsername" placeholder="검색창..">
							<button type="submit" class="btn btn-primary">검색하기</button>
						</div>
					</form>


					<div>
						<button type = "button" class="btn btn-primary" id="deleteAll">전체 삭제</button>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>
									<input type="checkbox" id="all">
								</th>
								<th>Product Num</th>
								<th>Product Name</th>
								<th>Product Rate</th>
								<th>Product Ex</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="dto">
								<tr>
									<td>
										<input type="checkbox" class="ch" data-wish-id="${dto.product_num}">
									</td>
									<td>${pageScope.dto.product_num}</td>
									<td><a type="button" class="btn btn-outline-dark" style="width:300px;" href="/product/detail?product_num=${pageScope.dto.product_num }">${pageScope.dto.product_name }</a></td>
									<td>${pageScope.dto.product_rate}</td>
									<td>${pageScope.dto.product_ex}</td>
									<td><button class="btn btn-outline-dark wishDelete" type="button" data-wish-id="${dto.product_num}">X</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link"
								href="/product/list?page=${pager.startNum - 1 }&kind=${pager.kind}&search=${pager.search}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>

							<c:forEach begin="${pager.startNum }" end="${pager.lastNum }"
								step="1" var="i">
								<li class="page-item"><a class="page-link"
									href="/product/list?page=${i }&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							</c:forEach>	

							<li class="page-item ${pager.next?'':'disabled' }"><a
								class="page-link"
								href="/product/list?page=${pager.lastNum + 1 }&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>

				</div>
			</div>
			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
		<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
	</div>
	<script src="/resources/js/product/wishDelete.js"></script>
</body>
</html>