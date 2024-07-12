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

	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.board_num }</td>
						<td>${dto.board_category }</td>
						<td><a href="/notice/detail?board_num=${dto.board_num }">${dto.board_title }</a></td>
						<td>${dto.board_writer }</td>
						<td>${dto.create_date }</td>
						<td>${dto.update_date }</td>
						<td>${dto.board_hit }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<div>
			<a href="/notice/add" class="btn btn-outline-primary">게시글 등록</a>
		</div>
	</div>
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>