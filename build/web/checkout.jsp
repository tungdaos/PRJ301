<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Checkout</title>
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
				<h1 class="font-weight-semi-bold text-uppercase mb-3">Checkout</h1>
				<div class="d-inline-flex">
					<p class="m-0"><a href="">Home</a></p>
					<p class="m-0 px-2">-</p>
					<p class="m-0">Checkout</p>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Checkout Start -->
		<div class="container-fluid pt-5">
			<div class="row px-xl-5">
				<div class="col-lg-8">
					<div class="mb-4">
						<h4 class="font-weight-semi-bold mb-4">Receiver Information</h4>
						<div class="row">
							<div class="col-md-6 form-group">
								<label>Receiver Name</label>
								<input class="form-control" type="text" value="${sessionScope.account.username}">
							</div>
							<div class="col-md-6 form-group">
								<label>E-mail</label>
								<input class="form-control" type="text" value="${sessionScope.account.email}">
							</div>
							<div class="col-md-6 form-group">
								<label>Mobile No</label>
								<input class="form-control" type="text" value="${sessionScope.account.phone}">
							</div>
							<div class="col-md-6 form-group">
								<label>Ship to</label>
								<input class="form-control" type="text" value="${sessionScope.account.city}">
								<input class="form-control" type="text" value="${sessionScope.account.district}">
								<input class="form-control" type="text" value="${sessionScope.account.address}">
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card border-secondary mb-5">
						<div class="card-header bg-secondary border-0">
							<h4 class="font-weight-semi-bold m-0">Order Total</h4>
						</div>

						<div class="card-body">
							<c:forEach items="${sessionScope.cart.items}" var="item">
								<h5 class="font-weight-medium mb-3">Products</h5>
								<div class="d-flex justify-content-between">
									<p>${item.product.productname} x ${item.quantity}</p>
									<p>${item.getPrice()}</p>
								</div>
							</c:forEach>
						</div>
						<div class="card-footer border-secondary bg-transparent">
							<div class="d-flex justify-content-between mt-2">
								<h5 class="font-weight-bold">Total</h5>
								<h5 class="font-weight-bold">${cart.getTotal()}</h5>
							</div>
						</div>

					</div>
					<div class="card border-secondary mb-5">
						<form action="checkout" method="post">
							<div class="card-footer border-secondary bg-transparent">
								<button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place Order</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Checkout End -->


		<jsp:include page="include/footer.jsp"/>
	</body>

</html>