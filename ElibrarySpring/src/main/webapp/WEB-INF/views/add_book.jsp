
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD BOOK</title>
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
</style>

</head>
<body>

	<div class="topnav">
		<a  href="">eLibrary</a> <a href="">Home</a> <a class="active"
			href="add_book">Add Book</a> <a  href="view_book">View Book</a> <a
			href="">Issue Book</a> <a href="">View Issued Book</a> <a href="">Return
			Book</a> <a href="librarian_logout">Log out</a>
	</div>

	<H1>Add Book Form</H1>
	<form action="add_book_record" method="post">
		Call No.: <input type="text" name="callno"><br> Name : <input
			type="text" name="name"><br> Author : <input type="text"
			name="author"><br> Publisher : <input type="text"
			name="publisher"><br> Quantity: <input type="text"
			name="quantity"><br> <input type="submit" value="Add">
	</form>

</body>
</html>