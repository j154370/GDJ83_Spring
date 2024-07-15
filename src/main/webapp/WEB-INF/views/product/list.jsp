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
		<!-- 검색 입력 폼 -->
		<form action="/product/list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
		
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select name="kind" class="form-select" id="inlineFormSelectPref">
		      <option value="k1">상품명</option>
		      <option value="k2">상품 내용</option>
		    </select>
		  </div>
		  
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
		    <div class="input-group">
		      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
		    </div>
		  </div>
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">검색하기</button>
		  </div>
		</form>
		
		
		
		
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품 번호</th>
					<th>상품명</th>
					<th>이자율</th>
					<th>상품 설명</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${pageScope.dto.product_num }</td>
						<td><a href="/product/detail?product_num=${pageScope.dto.product_num }">${pageScope.dto.product_name }</a></td>
						<td>${pageScope.dto.product_rate }</td>
						<td>${pageScope.dto.product_ex }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="/product/list?page=${pager.startNum - 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		  
		    <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" step="1" var="i">
		    	<li class="page-item"><a class="page-link" href="/product/list?page=${i }&kind=${pager.kind}&search=${pager.search}">${i}</a></li>		    
		    </c:forEach>
		   
		    <li class="page-item ${pager.next?'':'disabled' }">
		      <a class="page-link" href="/product/list?page=${pager.lastNum + 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		
		<div>
			<a href="add" class="btn btn-outline-primary">상품 등록</a>
		</div>
	</div>
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>