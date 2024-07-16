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
	<h1>${board }</h1>
		<!-- 검색 입력 폼 -->
		<form class="row row-cols-lg-auto g-3 align-items-center">
		
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select name="kind" class="form-select" id="inlineFormSelectPref">
		      <option value="title">글 제목</option>
		      <option value="contents">글 내용</option>
		      <option value="writer">작성자</option>
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
						<td>
							<c:if test="${dto.del eq 0 }">
								${dto.board_num }
							</c:if>		
						</td>
						<td>${dto.board_category }</td>
						<c:choose>
							<c:when test="${dto.del eq 0 }">
								<a href="./detail?board_num=${dto.board_num }">
								<c:catch>
									<c:forEach begin="1" end="${dto.depth }">┗></c:forEach>						
								</c:catch>
								${dto.board_title }
								</a>
							</c:when>
							<c:otherwise>
								삭제된 글입니다.
							</c:otherwise>
						</c:choose>
						
						<td>${dto.board_writer }</td>
						<td>${dto.create_date }</td>
						<td>${dto.update_date }</td>
						<td>${dto.board_hit }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.startNum-1 }" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
		    <c:forEach begin="${pager.startNum }" end="${pager.lastNum}" step="1" var="i" >
		    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>		    
		    </c:forEach>
		    
		    <li class="page-item ${pager.next?'' : 'disabled' }">
		      <a class="page-link" href="./list?page=${pager.lastNum+1 }" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		<div>
			<a href="./add" class="btn btn-outline-primary">게시글 등록</a>
		</div>
	</div>
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>