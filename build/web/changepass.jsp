<%-- 
    Document   : login
    Created on : Jun 15, 2022, 2:30:23 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title>Change Password</title>
		<link rel="stylesheet" href="css/login.css">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<h1>Change password</h1>
			<div class="text-center">
				<p class="text-danger">${requestScope.alert}</p>
			</div>
			<form action="changepass" method="post">
				<div class="txt_field">
					<input type="password" name="oldpassword" required>
					<span></span>
					<label>Old Password</label>
				</div>
				<div class="txt_field">
					<input type="password" name="newpassword" required>
					<span></span>
					<label>New Password</label>
				</div>
				<div class="txt_field">
					<input type="password" name="confirmpassword" required>
					<span></span>
					<label>Confirm Password</label>
				</div>
				<input type="submit" value="Save">
				<div class="signup_link">
					<a href="home">back to homepage</a>
				</div>
			</form>
		</div>

	</body>
</html>
