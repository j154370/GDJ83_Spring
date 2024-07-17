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
					<h1>Product Update</h1>
					<form action="/product/update" method="post">

						<div class="mb-3">
							<label for="Product Name" class="form-label">Product Name</label>
							<input type="text" class="form-control" id="Product Name"
								name="product_num" value ="${dto.product_name}">
						</div>

						<div class="mb-3">
							<label for="Product Rate" class="form-label">Product Rate</label>
							<input type="text" class="form-control" id="Product Rate"
								name="product_rate" value ="${dto.product_rate}">
						</div>

						<div class="mb-3">
							<label for="Product Ex" class="form-label">Product Ex</label> <input
								type="text" class="form-control" id="Product Ex"
								name="product_ex" value ="${dto.product_ex}">
						</div>

						<button type="submit" class="btn btn-primary">등록</button>

					</form>

				</div>

				<!-- 기본 끝 -->
			</div>
			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
		<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
	</div>
</body>
</html>