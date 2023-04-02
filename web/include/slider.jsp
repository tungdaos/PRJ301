<%-- 
    Document   : slider
    Created on : Jun 18, 2022, 8:20:26 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header-carousel" class="carousel slide" data-ride="carousel">
	<div class="carousel-inner">
		<div class="carousel-item active" style="height: 410px;">
			<img class="img-fluid" src="img/shopnow.jpg" alt="Image">
			<div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
				<div class="p-3" style="max-width: 700px;">
					<h3 class="display-4 text-white font-weight-semi-bold mb-4">All product</h3>
					<a href="shop" class="btn btn-light py-2 px-3">Shop Now</a>
				</div>
			</div>
		</div>
		<c:forEach items="${sessionScope.allcollections}" var="collection">
			<c:if test="${collection.collectionid ne 'none'}">
				<div class="carousel-item" style="height: 410px;">
					<img class="img-fluid" src="${collection.collectionimg}" alt="Image">
					<div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
						<div class="p-3" style="max-width: 700px;">
							<h3 class="display-4 text-white font-weight-semi-bold mb-4">${collection.collectionname}</h3>
							<a href="shop?colid=${collection.collectionid}" class="btn btn-light py-2 px-3">Shop Now</a>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>
	<a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
		<div class="btn btn-dark" style="width: 45px; height: 45px;">
			<span class="carousel-control-prev-icon mb-n2"></span>
		</div>
	</a>
	<a class="carousel-control-next" href="#header-carousel" data-slide="next">
		<div class="btn btn-dark" style="width: 45px; height: 45px;">
			<span class="carousel-control-next-icon mb-n2"></span>
		</div>
	</a>
</div>
