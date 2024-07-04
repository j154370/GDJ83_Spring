<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="/product/list">금융 상품</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
<%-- 
  <c:if test="${empty dto }">
  	<li class="nav-item">
    	<a class="nav-link" href="/member/join">회원가입</a>
  	</li>
  	<li class="nav-item">
    	<a class="nav-link" href="/member/login">로그인</a>
  	</li> 
  </c:if>
  <c:if test="${not empty dto }">
  	<li class="nav-item">
    	<a class="nav-link" href="/member/mypage">마이페이지</a>
  	</li>
  	<li class="nav-item">
    	<a class="nav-link" href="/member/logout">로그아웃</a>
  	</li> 
  </c:if>
--%>
  <c:choose>
  	<c:when test="${not empty dto }">
  		<li class="nav-item">
    		<a class="nav-link" href="/member/mypage">마이페이지</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/member/logout">로그아웃</a>
  		</li> 
  	</c:when>
  	<c:otherwise>
  		<li class="nav-item">
    		<a class="nav-link" href="/member/join">회원가입</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/member/login">로그인</a>
  		</li> 
  	</c:otherwise>
  </c:choose>
  
</ul>