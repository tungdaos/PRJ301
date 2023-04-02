<%-- 
    Document   : test
    Created on : Jul 13, 2022, 2:10:32 PM
    Author     : TM080522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Hello World!</h1>
		${requestScope.account}<br/>
		${requestScope.cart.getItems()}<br/>
		${requestScope.dao.getStatus()}
	</body>
</html>
