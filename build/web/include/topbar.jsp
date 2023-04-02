<%-- 
    Document   : topbar
    Created on : Jun 15, 2022, 2:54:01 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Topbar Start -->
<div class="container-fluid" >
	<div class="row align-items-center py-3 px-xl-5" style="background-color: #FFF">
            <div class="col-lg-3 d-none d-lg-block">
			<a href="home" class="text-decoration-none">
				<h2 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Fresh</span>Food</h2>
			</a>
            </div>
            <div class="col-lg-6 col-6 text-left">
			<form action="shop" method="get">
				<div class="input-group">
					<c:if test="${sessionScope.colid != null}">
						<input type="hidden" name="colid" value="${sessionScope.colid}">
					</c:if>
					<c:if test="${sessionScope.catid != null}">
						<input type="hidden" name="catid" value="${sessionScope.catid}">
					</c:if>	
					<input type="text" class="form-control" name="searchstring" placeholder="Search for products">
					<button type="submit" class="btn btn-primary px-3"><i class="fa fa-search"></i></button>
				</div>
			</form>
            </div>
            <div class="col-lg-3 col-6 text-right">
			<b style="font-size: 20px;">${sessionScope.account.username}</b>
			<a href="<c:if test="${sessionScope.account ne null}">profile</c:if><c:if test="${sessionScope.account eq null}">login</c:if>" class="btn border">
					<i class="fas fa-user text-primary"></i>
				</a>
			<c:if test="${sessionScope.account.role ne true}">
				<a href="cart" class="btn border">
					<i class="fas fa-shopping-cart text-primary"></i>
				</a>
			</c:if>
            </div>
	</div>
</div>
<!-- Topbar End -->

