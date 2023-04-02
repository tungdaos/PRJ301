<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Management</title>
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
		<div class="container-fluid" >
			<div class="row align-items-center py-3 px-xl-5" style="background-color: #FFF">
				<div class="col-lg-3 d-none d-lg-block">
					<a href="home" class="text-decoration-none">
						<h2 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Fresh</span>Food</h2>
					</a>
				</div>
				<div class="col-lg-6 col-6 text-left">
					<form action="manageproduct" method="get">
						<div class="input-group">	
							<input type="text" class="form-control" name="searchstring" placeholder="Search for products" value="${requestScope.searchstring}">
							<button type="submit" class="btn btn-primary px-3"><i class="fa fa-search"></i></button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="container-xl">
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-4 text-center">
								<a href="manageproduct" style=""><h4 class="text-primary bg-secondary font-weight-bold">Products</h4></a>
							</div>
							<div class="col-sm-4 text-center">
								<a href="managecategory" class=""><h4 class="text-primary bg-secondary font-weight-bold">Categories</h4></a>
							</div>
							<div class="col-sm-4 text-center">
								<a href="managecollection" class=""><h4 class="text-primary bg-secondary font-weight-bold">Collections</h4></a>
							</div>
							<div class="col-sm-4 text-center">
								<a href="#" class=""><h4 class="text-primary bg-secondary font-weight-bold">Accounts(not finished)</h4></a>
							</div>
							<div class="col-sm-4 text-center">
								<a href="#" class=""><h4 class="text-primary bg-secondary font-weight-bold">Orders(not finished)</h4></a>
							</div>
							
						</div>
					</div>
					<div class="text-center">
						<h3 class="text-danger">${requestScope.alert}</h3>
					</div>
					<div class="table-title">
						<div class="row">
							<div class="col-sm-6">
								<h2 class="text-white font-weight-bold"><b>Manage Products</b></h2>
							</div>
							<div class="col-sm-6">
								<a href="#add" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New product</span></a>					
							</div>
						</div>
					</div>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th><th>Name</th><th>Description</th><th>Size</th><th>Price</th><th>Stock</th><th>Image</th><th>Category</th><th>Chronology</th><th>Sale Programs</th><th>Action</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.productlist}" var="product">
								<tr>
									<td>${product.productid}</td>
									<td>${product.productname}</td>
									<td>${product.description}</td>
									<td>${product.size}</td>
									<td>${product.price}</td>
									<td>${product.stock}</td>
									<td><img src="${product.image}" alt="" style="height: 100px;width: 80px;object-fit: fill;"></td><!-- comment -->
									<td>
										<c:forEach var="category" items="${sessionScope.allcategories}">
											<c:if test="${product.catid.toLowerCase() eq category.catid.toLowerCase()}">
												${category.catname}
											</c:if>
										</c:forEach>					
									</td>
									<td>${product.createid}</td>
									<td>
										<c:forEach var="collection" items="${sessionScope.allcollections}">
											<c:if test="${product.collectionid.toLowerCase() eq collection.collectionid.toLowerCase()}">
												${collection.collectionname}
											</c:if>
										</c:forEach>									
									</td>
									<td>
										<a href="updateproduct?id=${product.productid}"><i class="material-icons">&#xE254;</i></a>
										<a href="deleteproduct?id=${product.productid}"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>        
		</div>

		<!-- Add Modal HTML -->
		<div id="add" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="addproduct" method="post">
						<div class="modal-header">						
							<h4 class="modal-title">Add Product</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Category</label>
								<select name='category'>
									<c:forEach var="category" items="${sessionScope.allcategories}">
										<option value='${category.catid}' >${category.catname}</option>
									</c:forEach> 
								</select>
							</div>
							<div class="form-group">
								<label>ID</label>
								<input type="text" name="id" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Name</label>
								<input type="text" name="name" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Description</label>
								<input type="text" name="description" value="no description" class="form-control">
							</div>
							<div class="form-group">
								<label>Size</label>
								<input type="text" name="size" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Price</label>
								<input type="number" name="price" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Stock</label>
								<input type="number" name="stock" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label>
								<input type="text" name="image" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Sale Program</label>
								<select name='collection'>
									<c:forEach var="collection" items="${sessionScope.allcollections}">
										<option value='${collection.collectionid}' ${collection.collectionid eq 'none' ? "selected" : ""}>${collection.collectionname}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="submit" class="btn btn-success" value="Add">
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>