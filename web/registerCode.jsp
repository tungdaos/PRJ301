<%-- 
    Document   : registerCode
    Created on : Oct 23, 2022, 3:40:57 PM
    Author     : FPTShop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<title>Confirm Account</title>
		<link rel="stylesheet" href="css/login.css">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<h1>Enter Code</h1>
			<div class="text-center">
				<p class="text-danger">${requestScope.alert}</p>
			</div>
			<form action="registerCode" method="post">
				<div class="txt_field">
					<input type="text" name="code" required/>
					<span></span>
					<label>Code: </label>
				</div>				
				<input type="submit" value="Sign in">				
			</form>
		</div>

	</body>
</html>