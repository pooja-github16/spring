<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Section</title>
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
  		<a href="add_librarian">Add Librarian</a>
  		<a href="view_librarian">View Librarian</a>
 		 <a href="admin_logout">Log out</a>
	</div>
		
 	<h2>Admin Section</h2>
 	<br><br>
 	<ul>
 		<li> <a href="add_librarian">Add Librarian</a></li>
 		<li><a href="view_librarian"> View Librarian</a></li>
 		<li><a href="view_librarian"> Edit Librarian</a> </li>
 		<li><a href="view_librarian"> Delete Librarian</a> </li>
 	</ul>
 	<a href="AdminLogout"><button>logout</button></a>
 </body>
</html>