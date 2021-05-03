%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Librarian Form</title>
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
 		 <a  href="">eLibrary</a>
  		<a class="active" href="add_librarian">Add Librarian</a>
  		<a href="view_librarian">View Librarian</a>
 		 <a href="AdminLogout">Log out</a>
	</div>
	
	
	<h1> Add Librarian</h1>
	<form action="add_librarian_record" method="post">
		Name :<input type="text" name="name"><br>
		E-Mail :<input type="text" name="email"><br>
		Password :<input type="text" name="password"><br>
		Mobile No. :<input type="text" name="mob"><br>
		<input type="submit" value="ADD">
	</form>
	
</body>
</html>