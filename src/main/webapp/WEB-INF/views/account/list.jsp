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
		<a href="list?account_num=${param.account_num}&order=1">과거순 정렬</a>
		<a href="list?account_num=${param.account_num}&order=0">최신순 정렬</a>
		<a href="list?account_num=${param.account_num}&order=0&order2=0">입금 조회</a>
		<a href="list?account_num=${param.account_num}&order=0&order2=1">출금 조회</a>
		<a href="list?account_num=${param.account_num}&order=0">모두 조회</a>
	</div>

	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>계좌번호</th>
					<th>잔액</th>
					<th>거래종류</th>
					<th>이체금액</th>
					<th>거래날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${param.account_num }</td>
						<td>${dto.balance }</td>
						<td class=${dto.trade_type.equals("입금")?'text-primary':'text-danger' }>
							${dto.trade_type }
						</td>
						<td>${dto.trade_amount }</td>
						<td>${dto.trade_date }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>