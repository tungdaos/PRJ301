<%-- 
    Document   : cart
    Created on : Jun 17, 2022, 4:53:57 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Shopping Food</title>
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
				<h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
				<div class="d-inline-flex">
					<p class="m-0"><a href="">Home</a></p>
					<p class="m-0 px-2">-</p>
					<p class="m-0">Shopping Food</p>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Cart Start -->			
		<c:if test="${sessionScope.account.role ne true}">
			<div class="container-fluid pt-5">
				<div class="row px-xl-5">
					<div class="col-lg-8 table-responsive mb-5">
						<table class="table table-bordered text-center mb-0">
							<thead class="bg-secondary text-dark">
								<tr>
									<th>Products</th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
								<c:set var="cart" value="${requestScope.cart}"/>
							</thead>
							<tbody class="align-middle">
								<c:forEach items="${cart.items}" var="item">
									<tr>
										<td class="align-middle"><img src="${item.product.image}" alt="" style="width: 50px;"></td>
										<td class="align-middle">${item.product.productname}</td>
										<td class="align-middle">${item.price}</td>
										<td class="align-middle">
											<div class="input-group quantity mx-auto" style="width: 100px;">
												<div class="input-group-btn">
													<a href="process?action=-1&id=${item.product.productid}"><button class="btn btn-sm btn-primary btn-minus">
															<i class="fa fa-minus"></i>
														</button></a>
												</div>
												<input type="text" class="form-control form-control-sm bg-secondary text-center" value="${item.quantity}" readonly="readonly" >
												<div class="input-group-btn">
													<a href="process?action=1&id=${item.product.productid}"><button class="btn btn-sm btn-primary btn-plus">
															<i class="fa fa-plus"></i>
														</button></a>
												</div>
											</div>
										</td>
										<td class="align-middle">${item.price * item.quantity}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-lg-4">
						<div class="card border-secondary mb-5">
							<div class="card-header bg-secondary border-0">
								<h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
							</div>
							<div class="card-body">
								<div class="d-flex justify-content-between mb-3 pt-1">
									<h6 class="font-weight-medium">Subtotal</h6>
									<h6 class="font-weight-medium">${cart.getTotal()} VND</h6>
								</div>
								<div class="d-flex justify-content-between">
									<h6 class="font-weight-medium">Shipping</h6>
									<h6 class="font-weight-medium">Free Ship</h6>
								</div>
							</div>
							<div class="card-footer border-secondary bg-transparent">
								<div class="d-flex justify-content-between mt-2">
									<h5 class="font-weight-bold">Total</h5>
									<h5 class="font-weight-bold">${cart.getTotal()} VND</h5>
								</div>
								<form action="checkout" method="">
									<button type="submit" class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<!-- Cart End -->


		<!-- Footer Start -->
		<jsp:include page="include/footer.jsp"/>
		<!-- Footer End -->
	</body>

</html>