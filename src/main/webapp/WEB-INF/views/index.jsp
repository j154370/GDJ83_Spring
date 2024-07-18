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
	<!-- Page Wrapper -->
    <div id="wrapper">
    	<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>
    	
    	<!-- 본문 내용 -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
    	            <!-- Main Content -->
            <div id="content">
            	<!-- 상단 바 -->
            	<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>
            	
            	
            	
            	
            </div>
            <!-- 하단 바 (footer) -->
            <c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
            
      	</div>
        <!-- End of Content Wrapper -->
        
        <!-- 하단 바 -->
        <c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
            
    </div>
    <!-- End of Page Wrapper -->
    
	
</body>
</html>