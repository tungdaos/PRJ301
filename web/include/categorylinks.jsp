<%-- 
    Document   : categorylinks
    Created on : Jun 15, 2022, 3:37:29 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-3 d-none d-lg-block">
	<a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
		<h6 class="m-0">Categories</h6>
		<i class="fa fa-angle-down text-dark"></i>
	</a>
	<nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
		<div class="navbar-nav w-100 overflow-hidden" style="height: auto">
			<c:forEach items="${sessionScope.categorylist}" var="category">
					<a href="shop?catid=${category.catid}<c:if test="${sessionScope.colid != null}">&colid=${sessionScope.colid}</c:if><c:if test="${sessionScope.searchstring != null}">&searchstring=${sessionScope.searchstring}</c:if>" class="nav-item nav-link">${category.catname}</a>
			</c:forEach>
		</div>
	</nav>
</div>
