<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Page</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

body {
	background-image: url("C:\Users\HP\Desktop\image.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>

</head>
<body>

	<div class="topnav">
		<a class="active" href="">eLibrary</a> <a href="login">Home</a> <a
			href="login.jsp">Admin</a> <a href="login">Librarian</a>
	</div>

	
	<form action="admin_login" method="post">
		<h3>Admin Login</h3>

		<br> Email Address: <input type="email" name="email"><br>
		<br> Password:<input type="password" name="password"><br>
		<br> <input type="submit" value="Login">
	</form>
	<br>
	<hr>
	<br>
	

	<form action="librarian_login" method="post">
		<h3>Librarian Login</h3>
		<br> Email Address: <input type="email" name="email"><br>
		<br> Password:<input type="password" name="password"><br>
		<br> <input type="submit" value="Login">
	</form>


</body>
</html>