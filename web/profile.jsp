<%-- 
    Document   : profile
    Created on : Jun 15, 2022, 4:48:36 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="DAL.DAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


		<link href="css/profile.css" rel="stylesheet">
		<title>profile</title>
	</head>
	<body>
		<!--Topbar start-->
		<jsp:include page="include/topbar.jsp"/>
		<!--Topbar end-->

		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right">
					<div class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" width="150px" src="https://i1.sndcdn.com/avatars-000294588695-dofuqj-t500x500.jpg">
						<span class="font-weight-bold">${sessionScope.account.username}</span>
						<span> </span>
					</div>
				</div>
				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right">Profile Settings</h4>
						</div>					
						<div class="text-center"><p class="text-danger">${requestScope.alert}</p></div>
						<form action="profile" method="post">
							<div class="row mt-3">
								<div class="col-md-12"><label class="labels">Email:</label> ${sessionScope.account.email}</div>
								<div class="col-md-12"><label class="labels">User Name: </label><input type="text" name="username" class="form-control" placeholder="enter user name" value="${sessionScope.account.username}"></div>
								<div class="col-md-12"><label class="labels">Mobile Number: </label><input type="text" name="phone" class="form-control" placeholder="enter phone number" value="${sessionScope.account.phone}"></div>
							</div>
							<div class="row mt-3">
								<div class="col-md-6"><label class="labels">City</label><input type="text" name="city" class="form-control" placeholder="city" value="${sessionScope.account.city}"></div>
								<div class="col-md-6"><label class="labels">District</label><input type="text" name="district" class="form-control" value="${sessionScope.account.district}" placeholder="district"></div>
								<div class="col-md-12"><label class="labels">Detail Address: </label><input type="text" name="address" class="form-control" placeholder="address" value="${sessionScope.account.address}"></div>
							</div>
							<div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
						</form>

						<div class="mt-5 text-center">
							<a href="changepass" class="btn btn-primary profile-button" type="button">Change Password</a>
							<a href="deleteacc?email=${sessionScope.account.email}" class="btn btn-primary profile-button" type="button">Delete Account</a>
							<a href="login" class="btn btn-primary profile-button" style="background-color: rgb(255,33,33)">Log out</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="include/footer.jsp"/>
	</body>
</html>
