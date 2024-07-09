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

	<h1>제품 정보 페이지</h1>
	
	<div>
		<h3>상품명 : ${dto.productDTO.product_name}</h3>
		<h3>이자율 : ${dto.productDTO.product_rate}</h3>
		<h3>계좌 번호 : ${dto.account_num }</h3>
		<h3>회원 아아디 : ${dto.user_id }</h3>
		<h3>상품 번호: ${dto.product_num }</h3>
		<h3>잔액 : ${dto.balance }</h3>
		<h3>개설일 : ${dto.account_date }</h3>
	</div>
	
	
	<a href="/account/transfer?account_num=${dto.account_num }">이체</a>
	

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>