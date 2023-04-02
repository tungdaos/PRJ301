<%-- 
    Document   : index.jsp
    Created on : Jun 15, 2022, 3:00:32 PM
    Author     : TM080522
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<meta content="width=device-width, initial-scale=1.0" name="viewport">
		<meta content="Free HTML Templates" name="keywords">
		<meta content="Free HTML Templates" name="description">

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
		<!--Topbar start-->
		<jsp:include page="include/topbar.jsp"/>
		<!--Topbar end-->

		<!-- Navbar Start -->
		<div class="container-fluid mb-5">
			<div class="row border-top px-xl-5">
				<!--categories--><jsp:include page="include/categorylinks.jsp"/>
				<div class="col-lg-9">
					<%--navigation bar--%><jsp:include page="include/navlinks.jsp"/>
					<%--slider--%><jsp:include page="include/slider.jsp"/>					
				</div>
			</div>
		</div>
		<!-- Navbar End -->

		<!-- Products Start -->
		<div class="container-fluid pt-5">
			<div class="text-center mb-4">
				<h2 class="section-title px-5"><span class="px-2">You may like</span></h2>
			</div>
			<div class="row px-xl-5 pb-3">
				<c:forEach items="${homeproductlist}" var="product">
					<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
						<div class="card product-item border-0 mb-4">
							<div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0" style=" height: 450px;position: relative;">
								<img class="img-fluid w-100" src="${product.image}" alt="" style="height: 100%;object-fit: fill;">
							</div>
							<div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
								<a href="itemdetail?productid=${product.productid}"><h6 class="text-truncate mb-3">${product.productname}_${product.size}</h6></a>
								<c:if test="${product.discountprice < product.price}">
									<div class="d-flex justify-content-center">
										<h6>${product.discountprice}</h6>
										<h6 class="text-muted ml-2"><del>${product.price}</del></h6>
									</div>
								</c:if>
								<c:if test="${product.discountprice == product.price}">
									<h6>${product.price}</h6>
								</c:if>
							</div>
							<div class="card-footer d-flex justify-content-between bg-light border">
								<a href="itemdetail?productid=${product.productid}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
								<c:if test="${product.stock > 0}">
									<c:if test="${sessionScope.account.role ne true}">
										<form action="cart" method="post">
											<input type="hidden" name="productid" value="${product.productid}">
											<input type="hidden" name="quantity" value="1">
											<button class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
										</form>
									</c:if>
								</c:if>
								<c:if test="${product.stock < 1}">
									<p>sold out!</p>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- Products End -->

		<!-- Vendor Start -->
		<div class="container-fluid py-5">
			<div class="text-center mb-4">
				<h2 class="section-title px-5"><span class="px-2">Just Arrived</span></h2>
			</div>
			<div class="row px-xl-5">
				<div class="col">
					<div class="owl-carousel vendor-carousel">
						<c:forEach items="${sessionScope.latestlist}" var="product">
							<div class="vendor-item">
								<div class="card product-item border-0 mb-4">
									<div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0" style=" height: 300px;position: relative;">
										<img class="img-fluid w-100" src="${product.image}" alt="" style="height: 100%;object-fit: fill;">
									</div>
									<div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<a href="itemdetail?productid=${product.productid}"><h6 class="text-truncate mb-3">${product.productname}_${product.size}</h6></a>
										<c:if test="${product.discountprice < product.price}">
											<div class="d-flex justify-content-center">
												<h6>${product.discountprice}</h6>
												<h6 class="text-muted ml-2"><del>${product.price}</del></h6>
											</div>
										</c:if>
										<c:if test="${product.discountprice == product.price}">
											<h6>${product.price}</h6>
										</c:if>
									</div>
									<div class="card-footer d-flex justify-content-between bg-light border">
										<a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
										<c:if test="${product.stock > 0}">
											<c:if test="${sessionScope.account.role ne true}">
												<form action="cart" method="post">
													<input type="hidden" name="productid" value="${product.productid}">
													<input type="hidden" name="quantity" value="1">
													<button class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
												</form>
											</c:if>
										</c:if>
										<c:if test="${product.stock < 1}">
											<p>sold out!</p>
										</c:if>
									</div>
								</div>
							</div>			
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!-- Vendor End -->

		<!--Footer start-->
		<jsp:include page="include/footer.jsp"/>
		<!--Footer end-->		
	</body>

</html>
