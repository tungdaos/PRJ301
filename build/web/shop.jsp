<%-- 
    Document   : shop
    Created on : Jun 15, 2022, 3:41:56 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Products</title>
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
				<h1 class="font-weight-semi-bold text-uppercase mb-3">Our Shop</h1>
				<div class="d-inline-flex">
					<h5 class="m-0"><a href="">Home</a></h5>
					<h5 class="m-0 px-2">-</h5>
					<h5 class="m-0">Shop</h5>
					<c:forEach items="${sessionScope.allcollections}" var="collection">
						<c:if test="${collection.collectionid eq sessionScope.colid}">
							<h5 class="m-0 px-2">-</h5>
							<h5 class="m-0">Collection: ${collection.collectionname}</h5>
						</c:if>
					</c:forEach>
					<c:forEach items="${sessionScope.allcategories}" var="category">
						<c:if test="${category.catid eq sessionScope.catid}">
							<h5 class="m-0 px-2">-</h5>
							<h5 class="m-0">Category: ${category.catname}</h5>
						</c:if>
					</c:forEach>
					<c:if test="${sessionScope.searchstring != null}">
						<h5 class="m-0 px-2">-</h5>
						<h5 class="m-0">Input: ${sessionScope.searchstring}</h5>
					</c:if>		
				</div>
			</div>
		</div>
		<!-- Page Header End -->

		<!-- Shop Start -->
		<div class="container-fluid pt-5">
			<div class="row px-xl-5">
				<!-- Shop Sidebar Start -->
				<div class="col-lg-2 col-md-12">
					<!-- Price Start -->
					<div class="border-bottom mb-4 pb-4">
<!--						<h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
						<form  id="form1"action="shop" method="post" style="text-align: center;">
							<c:if test="${sessionScope.colid != null}">
								<input type="hidden" name="colid" value="${sessionScope.colid}">
							</c:if>
							<c:if test="${sessionScope.catid != null}">
								<input type="hidden" name="catid" value="${sessionScope.catid}">
							</c:if>
							<c:if test="${sessionScope.searchstring != null}">
								<input type="hidden" name="searchstring" value="${sessionScope.searchstring}">
							</c:if>
							From: <input type="number" name="startprice" value="${sessionScope.startprice}" min="0"></br>
							To: <input type="number" name="endprice" value="${sessionScope.endprice}"></br>
							<input type='submit' value='Filter'>-->
						</form>
					</div>
					<!-- Price End -->
				</div>
				<!-- Shop Sidebar End -->


				<!-- Shop Product Start -->
				<div class="col-lg-9 col-md-12">
					<div class="row pb-3">
						<!--sort start-->
						<div class="col-12 pb-1">
							<div class="d-flex align-items-center justify-content-end mb-4">
								<div class="dropdown ml-4">
									<button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
										  aria-expanded="false">
										Sort by <c:if test="${sessionScope.order == 1}">Latest</c:if><c:if test="${sessionScope.order == 2}">Oldest</c:if><c:if test="${sessionScope.order == 3}">Price++</c:if><c:if test="${sessionScope.order == 4}">Price--</c:if>
										</button>
										<div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
														<a class="dropdown-item" href="shop?<c:if test="${sessionScope.colid != null}">colid=${sessionScope.colid}&</c:if><c:if test="${sessionScope.catid != null}">catid=${sessionScope.catid}&</c:if><c:if test="${sessionScope.searchstring != null}">searchstring=${sessionScope.searchstring}&</c:if>order=1">Latest</a>
										<a class="dropdown-item" href="shop?<c:if test="${sessionScope.colid != null}">colid=${sessionScope.colid}&</c:if><c:if test="${sessionScope.catid != null}">catid=${sessionScope.catid}&</c:if><c:if test="${sessionScope.searchstring != null}">searchstring=${sessionScope.searchstring}&</c:if>order=2">Oldest</a>
										<a class="dropdown-item" href="shop?<c:if test="${sessionScope.colid != null}">colid=${sessionScope.colid}&</c:if><c:if test="${sessionScope.catid != null}">catid=${sessionScope.catid}&</c:if><c:if test="${sessionScope.searchstring != null}">searchstring=${sessionScope.searchstring}&</c:if>order=3">Price ++</a>
										<a class="dropdown-item" href="shop?<c:if test="${sessionScope.colid != null}">colid=${sessionScope.colid}&</c:if><c:if test="${sessionScope.catid != null}">catid=${sessionScope.catid}&</c:if><c:if test="${sessionScope.searchstring != null}">searchstring=${sessionScope.searchstring}&</c:if>order=4">Price --</a>
										</div>
									</div>

								</div>
							</div>
							<!--sort end-->
							<div class="text-center">
										<h3 class="text-danger">${requestScope.alert}</h3>
						</div>
						<c:set var="page" value="${sessionScope.page}"/>
						<c:forEach items="${sessionScope.finalproductlist}" var="product">
							<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
								<div class="card product-item border-0 mb-4">
									<div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0" style=" height: 400px;position: relative;">
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
											<h6>${product.discountprice}</h6>
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
										<c:if test="${product.stock == 0}">
											<p>sold out!</p>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="col-12 pb-1">

							<nav aria-label="Page navigation">
								<ul class="pagination justify-content-center mb-3">
									<c:forEach begin="1" end="${sessionScope.numberofpage}" var="i">
										<li class="page-item"><a class="page-link" href="shop?<c:if test="${sessionScope.colid != null}">colid=${sessionScope.colid}&</c:if><c:if test="${sessionScope.catid != null}">catid=${sessionScope.catid}&</c:if><c:if test="${sessionScope.searchstring != null}">searchstring=${sessionScope.searchstring}&</c:if><c:if test="${sessionScope.order != null}">order=${sessionScope.order}&</c:if>page=${i}">${i}</a>
											</li>
									</c:forEach>
								</ul>
							</nav>
						</div>
					</div>
				</div>
				<!-- Shop Product End -->
			</div>
		</div>
		<!-- Shop End -->


		<jsp:include page="include/footer.jsp"/>
	</body>

</html>