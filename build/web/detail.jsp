<%-- 
    Document   : detail
    Created on : Jun 15, 2022, 4:06:06 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Detail</title>
		<meta content="width=device-width, initial-scale=1.0" name="viewport">

		<!-- Favicon -->
		<link href="img/favicon.ico" rel="icon">

		<!-- Google Web Fonts -->
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

		<!-- Font Awesome -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

		<!-- Libraries Stylesheet -->
		<link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

		<!-- Customized Bootstrap Stylesheet -->
		<link href="css/style.css" rel="stylesheet">
	</head>

	<body>
		<!-- Topbar Start -->
		<jsp:include page="include/topbar.jsp"/>
		<!-- Topbar End -->


		<!-- Navbar Start -->
		<div class="container-fluid">
			<div class="row border-top px-xl-5">
				<!--categories--><jsp:include page="include/categorylinks.jsp"/>
				<div class="col-lg-9">
					<%--navigation bar--%><jsp:include page="include/navlinks.jsp"/>
				</div>
			</div>
		</div>
		<!-- Navbar End -->


		<!-- Page Header Start -->
		<div class="container-fluid bg-secondary mb-5">
			<div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
				<h1 class="font-weight-semi-bold text-uppercase mb-3">Shop Detail</h1>
				<div class="d-inline-flex">
					<p class="m-0"><a href="">Home</a></p>
					<p class="m-0 px-2">-</p>
					<p class="m-0">Product Detail</p>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Shop Detail Start -->
		<div class="container-fluid py-5">
			<div class="row px-xl-5">
				<div class="col-lg-5 pb-5">
					<div id="product-carousel" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner border">
							<div class="carousel-item active">
								<img class="w-100 h-100" src="${requestScope.product.image}" alt="Image">
							</div>
						</div>
						<a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
							<i class="fa fa-2x fa-angle-left text-dark"></i>
						</a>
						<a class="carousel-control-next" href="#product-carousel" data-slide="next">
							<i class="fa fa-2x fa-angle-right text-dark"></i>
						</a>
					</div>
				</div>

				<div class="col-lg-7 pb-5">
					<h3 class="font-weight-semi-bold">${requestScope.product.productname}_${requestScope.product.size}</h3>
					<c:if test="${requestScope.product.discountprice < requestScope.product.price}">
						<h3 class="text-muted font-weight-semi-bold mb-4"><del>${requestScope.product.price}</del> VND</h3>
						<h3 class="font-weight-semi-bold mb-4">${requestScope.product.discountprice} VND</h3>
					</c:if>
					<c:if test="${requestScope.product.discountprice == requestScope.product.price}">
						<h3 class="font-weight-semi-bold mb-4">${requestScope.product.discountprice} VND</h3>
					</c:if>
					<p class="mb-4">${requestScope.product.description} chưa có description</p>
					<c:if test="${sessionScope.account.role ne true}">
						<c:if test="${requestScope.product.stock > 0}">
							<form action="cart" method="post">
								<input type="hidden" name="productid" value="${requestScope.product.productid}">
								<div class="d-flex align-items-center mb-4 pt-2">
									<div class="input-group quantity mr-3" style="width: 130px;">
										<input type="number" name="quantity" class="form-control bg-secondary text-center" value="1" min="1" max="${product.stock}">
									</div>
									<button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
								</div>
							</form>
						</c:if>
					</c:if>
					<c:if test="${requestScope.product.stock < 1}">
						<h5 class="font-weight-semi-bold mb-4">Sold out!</h5>
					</c:if>
				</div>
			</div>

		</div>
		<!-- Shop Detail End -->


		<!--Footer start-->
		<jsp:include page="include/footer.jsp"/>
		<!--Footer end-->
	</body>

</html>