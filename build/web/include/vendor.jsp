<%-- 
    Document   : vendor
    Created on : Jun 16, 2022, 9:00:24 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							<div class="d-flex justify-content-center">
								<h6>${product.price}</h6><h6 class="text-muted ml-2"><del>${product.price}</del></h6>
							</div>
						</div>
						<div class="card-footer d-flex justify-content-between bg-light border">
							<a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
							<a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
						</div>
					</div>
				</div>			
			</c:forEach>
		</div>
	</div>
</div>
