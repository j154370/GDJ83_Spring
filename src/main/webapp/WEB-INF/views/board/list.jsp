<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<!-- 시작 -->
				<div class = "container">
					<h1>${board} 리스트</h1>
					
					<form action="/product/list" method="get"
						class="row row-cols-lg-auto g-3 align-items-center">


						<div class="input-group">
							<select name="kind" class="form-select" id="inlineFormSelectPref">
								<option value="title">제목</option>
								<option value="contents">내용</option>
								<option value="writer">작성자</option>
							</select> <input type="text" name="search" class="form-control"
								id="inlineFormInputGroupUsername" placeholder="검색창..">
							<button type="submit" class="btn btn-primary">검색하기</button>
							<a href="./add" class="btn btn-outline-primary">게시글 등록</a>
						</div>
					</form>
					
				
				
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">번호</th>
					      <th scope="col">제목</th>
					      <th scope="col">작성자</th>
					      <th scope="col">작성일</th>
					      <th scope="col">수정일</th>
					      <th scope="col">조회수</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items = "${list}" var = "dto"> 
							<tr>
								<td> 
									<c:if test="${dto.del eq 0}">
										${dto.board_num}
									</c:if>
								</td>
								
								
								<td>
									<c:choose>
										<c:when test="${dto.del eq 0}">
											<a  type="button" 
												href="./detail?board_num=${dto.board_num}">
												<c:catch>
													<c:forEach begin="1" end="${dto.depth}">━━></c:forEach>
												</c:catch>	
												${dto.board_title}
											</a>
										</c:when>
										<c:otherwise>
												<c:catch>
													<c:forEach begin="1" end="${dto.depth}">━━></c:forEach>
												</c:catch>	
												삭제된 글입니다.
										</c:otherwise>
									</c:choose>
								 </td>
								 
								<td>
									<c:if test="${dto.del eq 0}">
										${dto.board_writer}
									</c:if>
								</td>
								<td>
									<c:if test="${dto.del eq 0}">
										${dto.create_date}
									</c:if>	
								</td>
								<td>
									<c:if test="${dto.del eq 0}">	
										${dto.update_date}
									</c:if>	
								</td>
								<td>
									<c:if test="${dto.del eq 0}">	
										${dto.board_hit}
									</c:if>	
								</td>
							</tr>
						</c:forEach>
					  </tbody>
					</table>
					
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link"
								href="/product/list?page=${pager.startNum - 1 }&kind=${pager.kind}&search=${pager.search}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>

							<c:forEach begin="${pager.startNum }" end="${pager.lastNum }"
								step="1" var="i">
								<li class="page-item"><a class="page-link"
									href="/product/list?page=${i }&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							</c:forEach>	

							<li class="page-item ${pager.next?'':'disabled' }"><a
								class="page-link"
								href="/product/list?page=${pager.lastNum + 1 }&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
			
				</div>
				
				<!-- 끝 -->
			</div>
			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
		<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
	</div>
</body>
</html>