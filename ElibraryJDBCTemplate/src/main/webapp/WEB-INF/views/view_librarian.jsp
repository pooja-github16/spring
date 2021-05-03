<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.elibrary.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian record</title>
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
  		<a href="add_librarian">Add Librarian</a>
  		<a class="active" href="view_librarian">View Librarian</a>
 		 <a href="admin_logout">Log out</a>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>                 
			<th>Name</th>                 
			<th>Email</th>                 
			<th>Password</th>                 
			<th>Mob</th>                 
			<th>Action</th>
			<th>Action</th>        
		</tr>
		    
		<%
			List<Librarian> librarians = (List<Librarian>) request.getAttribute("librarians");

			for (Librarian librarian : librarians) {
			%>
		<tr>
			<td><%=librarian.getId()%></td>
			<td><%=librarian.getName()%></td>
			<td><%=librarian.getEmail()%></td>
			<td><%=librarian.getPassword()%></td>
			<td><%=librarian.getMob()%></td>
			<td><a href="update_librarian?id=<%=librarian.getId()%>"><button>Update</button></a></td>
			<td><a href="delete_librarian?id=<%=librarian.getId()%>"><button>Delete</button></a></td>
		</tr>
		<%
		}
		%>
	
</body>
</html>