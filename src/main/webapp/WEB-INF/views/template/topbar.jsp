<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!-- Topbar -->
<!-- Topbar -->
<nav
	class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop"
		class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	<!-- Topbar Search -->


	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">



		<!-- Nav Item - Alerts -->
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
				<span class="badge badge-danger badge-counter">1</span>
		</a> <!-- Dropdown - Alerts -->
			<div
				class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="alertsDropdown">
				<h6 class="dropdown-header">2</h6>
				<a class="dropdown-item d-flex align-items-center" href="#">
					<div class="mr-3">
						<div class="icon-circle bg-primary">
							<i class="fas fa-file-alt text-white"></i>
						</div>
					</div>
					<div>
						<div class="small text-gray-500">3</div>
						<span class="font-weight-bold">4</span>
					</div>
				</a> <a class="dropdown-item d-flex align-items-center" href="#">
					<div class="mr-3">
						<div class="icon-circle bg-success">
							<i class="fas fa-donate text-white"></i>
						</div>
					</div>
					<div>
						<div class="small text-gray-500">5</div>
						6
					</div>
				</a> <a class="dropdown-item d-flex align-items-center" href="#">
					<div class="mr-3">
						<div class="icon-circle bg-warning">
							<i class="fas fa-exclamation-triangle text-white"></i>
						</div>
					</div>
					<div>
						<div class="small text-gray-500">7</div>
						8
					</div>
				</a> <a class="dropdown-item text-center small text-gray-500" href="#">9</a>
			</div></li>

		<!-- Nav Item - Messages -->
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <!-- Counter - Messages -->
				<span class="badge badge-danger badge-counter">7</span>
		</a> <!-- Dropdown - Messages -->
			<div
				class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="messagesDropdown">
				<h6 class="dropdown-header">10</h6>
				<a class="dropdown-item d-flex align-items-center" href="#">
					<div class="dropdown-list-image mr-3">
						<img class="rounded-circle"
							src="/resources/img/undraw_profile_1.svg" alt="...">
						<div class="status-indicator bg-success"></div>
					</div>
					<div class="font-weight-bold">
						<div class="text-truncate">11</div>
						<div class="small text-gray-500">12</div>
					</div>
				</a> <a class="dropdown-item d-flex align-items-center" href="#">
					<div class="dropdown-list-image mr-3">
						<img class="rounded-circle"
							src="/resources/img/undraw_profile_2.svg" alt="...">
						<div class="status-indicator"></div>
					</div>
					<div>
						<div class="text-truncate">13</div>
						<div class="small text-gray-500">14</div>
					</div>
				</a> <a class="dropdown-item d-flex align-items-center" href="#">
					<div class="dropdown-list-image mr-3">
						<img class="rounded-circle"
							src="/resources/img/undraw_profile_3.svg" alt="...">
						<div class="status-indicator bg-warning"></div>
					</div>
					<div>
						<div class="text-truncate">15</div>
						<div class="small text-gray-500">16</div>
					</div>
			</div></li>

		<div class="topbar-divider d-none d-sm-block"></div>

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <span
				class="mr-2 d-none d-lg-inline text-gray-600 small">
				
				<c:choose>
					<c:when test="${not empty dto }">
						
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				</span> <img
				class="img-profile rounded-circle"
				src="/resources/img/undraw_profile.svg">
		</a> <!-- Dropdown - User Information -->
			<div
				class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="userDropdown">
				<c:choose>
					<c:when test="${not empty dto }">
						<a class="dropdown-item" href="/member/mypage"> <i
							class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> MyPage
						</a>
						<a class="dropdown-item" href="/member/logout"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							LogOut
						</a>
					</c:when>
					<c:otherwise>
						<a class="dropdown-item" href="/member/join"> <i
							class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> SignIn
						</a>
						<a class="dropdown-item" href="/member/login"> <i
							class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> LogIn
						</a>
					</c:otherwise>
				</c:choose>
			</div>
		</li>

	</ul>

</nav>
<!-- End of Topbar -->