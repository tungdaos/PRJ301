<%-- 
    Document   : navlinks
    Created on : Jun 15, 2022, 3:36:01 PM
    Author     : TM080522
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
	<a href="" class="text-decoration-none d-block d-lg-none">
		<h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">CHwT</span>Menswear</h1>
	</a>
	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
		<div class="navbar-nav mr-auto py-0">
			<a href="home" class="nav-item nav-link active">Home</a>
			<a href="preshop" class="nav-item nav-link">Products</a>
			<c:if test="${sessionScope.account.role eq true}">
				<a href="manageproduct" class="nav-item nav-link">Manage</a>
			</c:if>
			<div class="nav-item dropdown">
				<a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">Contact</a>
				<div class="dropdown-menu rounded-0 m-0">
					<p class="dropdown-item">Mail to us at: somewhere@gmail.com</p>
					<p class="dropdown-item">Hotline: 0123456789</p>
				</div>
			</div>
		</div>
		<div class="navbar-nav ml-auto py-0">
			<c:if test="${sessionScope.account ne null}">
				<a href="login" class="nav-item nav-link">Logout</a>
			</c:if>
			<c:if test="${sessionScope.account eq null}">
				<a href="login" class="nav-item nav-link">Login</a>
				<a href="signup" class="nav-item nav-link">Register</a>
			</c:if>
		</div>
	</div>
</nav>