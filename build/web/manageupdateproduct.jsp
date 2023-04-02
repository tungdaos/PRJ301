<%-- 
    Document   : manageupdateproduct
    Created on : Jun 27, 2022, 5:19:04 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Update product</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta content="width=device-width, initial-scale=1.0" name="viewport">
		<link href="img/favicon.ico" rel="icon">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
		<link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<link href="css/table.css" rel="stylesheet">
		<script src="js/table.js"></script>
	</head>
	<body>
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="updateproduct" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Update Product</h4>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>ID</label>
							<input type="text" name="id" value="${requestScope.id}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Name</label>
							<input type="text" name="name" value="${requestScope.name}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Description</label>
							<input type="text" name="description" value="${requestScope.description}" class="form-control">
						</div>
						<div class="form-group">
							<label>Size</label>
							<input type="text" name="size" value="${requestScope.size}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Price</label>
							<input type="number" name="price" value="${requestScope.price}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Stock</label>
							<input type="number" name="stock" value="${requestScope.stock}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Image</label>
							<input type="text" name="image" value="${requestScope.image}" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Category</label>
							<select name='category'>
								<c:forEach var="category" items="${sessionScope.allcategories}">
									<option value='${category.catid}' ${category.catid eq requestScope.category ? "selected":""} >${category.catname}</option>
								</c:forEach> 
							</select>
						</div>
						<div class="form-group">
							<label>Sale Program</label>
							<select name='collection'>
								<c:forEach var="collection" items="${sessionScope.allcollections}">
									<option value='${collection.collectionid}' ${collection.collectionid eq requestScope.collection ? "selected" : ""}>${collection.collectionname}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Save">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
