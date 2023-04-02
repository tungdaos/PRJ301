<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title>Register Form</title>
		<link rel="stylesheet" href="css/login.css">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<h1>Sign up</h1>
			<div class="text-center">
				<p class="text-danger">${requestScope.alert}</p>
			</div>
			<form action="signup" method="post">
				<div class="txt_field">
					<input type="text" name="username" required>
					<span></span>
					<label>Username</label>
				</div>
				<div class="txt_field">
					<input type="text" name="email" required>
					<span></span>
					<label>Email</label>
				</div>
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
				<div class="txt_field">
					<input type="text" name="quiz" required>
					<span></span>
					<label>Security Question</label>
				</div>
				<div class="txt_field">
					<input type="text" name="answer" required>
					<span></span>
					<label>Security Question Answer</label>
				</div>
				<input type="submit" value="Sign up">
				<div class="signup_link">
					Already a member? <a href="login">Sign in</a>
				</div>
			</form>
		</div>

	</body>
</html>
