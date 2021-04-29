<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book Form</title>
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
 		 <a class="active" href="">eLibrary</a>
  		<a href="">Home</a>
  		<a href="add_book">Add Book</a>
 		 <a href="view_book">View Book</a>
 		 <a href="issue_book">Issue Book</a>
 		 <a href="view_issued_book">View Issued Book</a>
 		 <a href="return_book_form">Return Book</a>
 		 <a href="librarian_logout">Log out</a>
	</div>
	
	<h1> Return Book Form</h1>
	<form action="return_book" method="post">
		Call No.: <input type="text" name="callno"><br>
		Student ID: <input type="text" name="sid"><br>
		<input type="submit"  value="Return Book">
	</form>
</body>
</html>