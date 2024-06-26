<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 정보 페이지</h1>
	
	
	<h3>${requestScope.dto.department_id }</h3>
	<h3>${requestScope.dto.department_name }</h3>
	<h3>${requestScope.dto.manager_id }</h3>
	<h3>${requestScope.dto.location_id }</h3>
	
	<a href="/department/delete?department_id=${requestScope.dto.department_id }">삭제</a>
	<a href="/department/update?department_id=${requestScope.dto.department_id }">수정</a>

</body>
</html>