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
            	
            	
            	<!-- 기본 끝 -->
            </div>
            <c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
      	</div>
        <c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import> 
    </div>
</body>
</html>