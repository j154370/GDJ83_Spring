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

	<h1>상세 페이지</h1>
	
	<h3>${requestScope.dto.product_num }</h3>
	<h3>${requestScope.dto.product_name }</h3>
	<h3>${requestScope.dto.product_rate }</h3>
	<h3>${requestScope.dto.product_ex }</h3>
	
	<a href="/account/add?product_num=${requestScope.dto.product_num }">상품 가입</a>
	<a href="/product/delete?product_num=${requestScope.dto.product_num }">삭제</a>
	<a href="/product/update?product_num=${requestScope.dto.product_num }">수정</a>
	

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>