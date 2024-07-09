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
			<h1>계좌 이체 페이지</h1>
		</div>
		<div class="row">
			<form action="/account/transfer" method="post">
				<input type="hidden" name="account_num" value="${dto.account_num }">
			
				<div class="mb-3">
					<label for="account_num" class="form-label">계좌 번호</label>
					<input type="text" class="form-control" id="account_num" name="account_num">
				</div>
				<div class="mb-3">
					<label for="trade_amount" class="form-label">이체 금액</label>
					<input type="text" class="form-control" id="trade_amount" name="trade_amount">
				</div>
				
				<button type="submit" class="btn btn-primary">등록</button>
			</form>

		</div>

	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>