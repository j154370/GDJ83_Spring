<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            	<h1>회원정보 페이지</h1>
	
	<h3>${dto.user_id }</h3>
	<h3>${dto.user_name }</h3>
	<h3>${dto.user_email }</h3>
	<h3>${dto.user_phone }</h3>
	<h3>${dto.user_address }</h3>

	<div>
		<h3>계좌정보</h3>
		<c:forEach items="${dto.dtos }" var="ac">
			<h3><a href="/account/detail?account_num=${ac.account_num }">${ac.account_num }</a> : ${ac.balance }원</h3>
		</c:forEach>
	</div>
	
	<a href="/member/update">회원 정보 수정</a>
	<form action="/member/delete" method ="post">
		<button type="submit" class = "btn btn-danger">회원탈퇴</button>
	</form>
            	
            	<!-- 기본 끝 -->
            </div>
            <c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
      	</div>
        <c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import> 
    </div>
</body>
</html>