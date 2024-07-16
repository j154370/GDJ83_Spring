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
	
	<h3>${dto.board_num }</h3>
	<h3>${dto.board_category }</h3>
	<h3>${dto.board_title }</h3>
	<h3>${dto.board_writer }</h3>
	<h3>${dto.create_date }</h3>
	<h3>${dto.update_date }</h3>
	<h3>${dto.board_hit }</h3>
	<h3>${dto.board_contents }</h3>
	
	<div>
		<c:if test="${board ne 'Notice' }">
			<a href="./reply?board_num=${dto.board_num }">답글</a>		
		</c:if>
		<c:if test="${sessionScope.dto.user_id eq dto.board_writer}">
		<a href="./delete?board_num=${dto.board_num }">삭제</a>
		<a href="./update?board_num=${dto.board_num }">수정</a>			
		</c:if>
	</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>