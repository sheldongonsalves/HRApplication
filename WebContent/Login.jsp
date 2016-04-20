<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Login</title>
</head>
<body background="http://www.ngahr.com/sites/default/files/background/slide1.png">

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand">Harrison Dalton Zork Business Process Application</a>
		</div>
	</nav>

	<form action="LoginServlet" method="post">
			<p>
				<h2>Welcome to HR Application</h2>
			</p>
				<p>${message}</p>
			
			User Name:<br> <input type="text" name="username" value="${param.username}"><br>
			Password:<br> <input type="password" name="password" value="${param.password}"><br>
			<br> <input type="submit" value="login">
	</form>
</body>
</html>
