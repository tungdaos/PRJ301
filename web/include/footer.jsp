<%-- 
    Document   : footer
    Created on : Jun 15, 2022, 3:06:47 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Footer Start -->
<div class="container-fluid bg-secondary text-dark pt-2">
	<div class="row px-xl-5">
            <div class="col-lg-4 col-md-12 pr-3 pr-xl-5 mb-2">
			<a href="" class="text-decoration-none">
				<h2 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">Fresh</span>Food</h2>
			</a>
			<p>Fresh Food ở đây ngon hơn người yêu bạn</p>
			<p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Đại Học FPT, Thạch Thất, Hà Nội</p>
			<p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>somewhere@gmail.com</p>
			<p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>012 345 67890</p>
            </div>
            <div class="col-lg-8 col-md-12">
			<div class="row justify-content-end">
				<div class="col-md-4 mb-2">
					<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
					<div class="d-flex flex-column justify-content-start">
						<a class="text-dark mb-2" href="home"><i class="fa fa-angle-right mr-2"></i>Home</a>
						<a class="text-dark mb-2" href="shop"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
						<a class="text-dark mb-2" href="<c:if test="${sessionScope.account ne null}">cart</c:if><c:if test="${sessionScope.account eq null}">login.jsp</c:if>"><i class="fa fa-angle-right mr-2"></i>Shopping Food</a>
					</div>
				</div>
			</div>
            </div>
	</div>
</div>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>
<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<!-- Template Javascript -->
<script src="js/main.js"></script>