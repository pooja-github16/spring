<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.elibrary.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Librarian Form</title>
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
  		<a href="add_librarian.jsp">Add Librarian</a>
  		<a href="view_librarian.jsp">View Librarian</a>
 		 <a href="admin_logout">Log out</a>
	</div>
	<% Librarian l =(Librarian) request.getAttribute("librarian"); %>
	<form action="update_librarian_record" method="post">
		<input type="hidden" name="id" value="<%= l.getId() %>">
		Name: <input type="text" name="name" value="<%= l.getName() %>"><br>
		E-mail: <input type="text" name="email" value="<%= l.getEmail() %>"><br>
		Password: <input type="password" name="password" value="<%= l.getPassword() %>"><br>
		Mobile No.: <input type="text" name="mob" value="<%= l.getMob() %>"><br>
		<input type="submit" value="Update">
		
	</form>
	
</body>
</html>