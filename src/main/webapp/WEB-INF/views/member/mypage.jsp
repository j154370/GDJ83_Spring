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


	<h1>회원정보 페이지</h1>
	
	<h3>${sessionScope.dto.member.user_id }</h3>
	<h3>${sessionScope.dto.member.user_name }</h3>
	<h3>${sessionScope.dto.member.user_email }</h3>
	<h3>${sessionScope.dto.member.user_phone }</h3>
	<h3>${sessionScope.dto.member.user_address }</h3>
	
	<div>
		<h3>계좌정보</h3>
		<c:forEach items="${dto.account }" var="ac">
			<h3>${ac.account_num } : ${ac.balance }</h3>
		</c:forEach>
	</div>
	
	<a href="/member/update">회원 정보 수정</a>
	<form action="/member/delete" method ="post">
		<button type="submit" class = "btn btn-danger">회원탈퇴</button>
	</form>
			


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>