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
		<title>Login Form</title>
		<link rel="stylesheet" href="css/login.css">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<h1>Sign in</h1>
			<div class="text-center">
				<p class="text-danger">${requestScope.alert}</p>
			</div>
			<form action="login" method="post">
				<div class="txt_field">
					<input type="text" name="email" required/>
					<span></span>
					<label>Email</label>
				</div>
				<div class="txt_field">
					<input type="password" name="password" required>
					<span></span>
					<label>Password</label>
				</div>
				<a href="forgetpass" class="pass">Forgot Password?</a>
				<input type="submit" value="Sign in">
				<div class="signup_link">
					Not a member? <a href="signup">Sign up</a>
				</div>
			</form>
		</div>

	</body>
</html>
