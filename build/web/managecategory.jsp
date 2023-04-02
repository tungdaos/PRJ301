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
								<h2 class="text-white font-weight-bold"><b>Manage Category</b></h2>
							</div>
							<div class="col-sm-6">
								<a href="#add" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add Category</span></a>					
							</div>
						</div>
					</div>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th><th>Name</th><th>Description</th><th>Action</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.allcategories}" var="category">
								<tr>
									<td>${category.catid}</td>
									<td>${category.catname}</td>
									<td>${category.catdes}</td>
									<td>
										<a href="managecategory?id=${category.catid}&delete=yes"><i class="material-icons">&#xE872;</i></a>
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
					<form action="managecategory" method="post">
						<div class="modal-header">						
							<h4 class="modal-title">Add Category</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
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