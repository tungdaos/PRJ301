<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title>Forget Password</title>
		<link rel="stylesheet" href="css/login.css">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<h1>Forget Password</h1>
			<div class="text-center">
				<p class="text-danger">${requestScope.alert}</p>
			</div>
			<form action="forgetpass" method="post">
				<c:if test="${requestScope.ask eq null && requestScope.pass eq null}">
					<div class="txt_field">
						<input type="text" name="email" value="${requestScope.filledemail}" required>
						<span></span>
						<label>Email</label>
					</div>
				</c:if>
				<c:if test="${requestScope.ask ne null}">
					<div class="txt_field">
						<span>${requestScope.filledemail}</span>
					</div>
					<div class="txt_field">
						<span>${requestScope.ask}</span>
					</div>
					<div class="txt_field">
						<input type="text" name="answer" required>
						<span></span>
						<label>Security Question Answer</label>
					</div>
				</c:if>
				<c:if test="${requestScope.pass ne null}">
				<div class="txt_field">
					<input type="password" name="password" required>
					<span></span>
					<label>Password</label>
				</div>
				<div class="txt_field">
					<input type="password" name="confirmpassword" required>
					<span></span>
					<label>Confirm Password</label>
				</div>
				</c:if>
				<input type="submit" value="Save">
				<div class="signup_link">
					<a href="home">Back to homepage</a>
				</div>
			</form>
		</div>

	</body>
</html>
