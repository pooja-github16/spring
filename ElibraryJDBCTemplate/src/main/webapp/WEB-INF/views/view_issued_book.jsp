<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, com.elibrary.controller.BookController,com.elibrary.model.IssuedBook" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ISSUED BOOK LIST</title>
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
	
	<h1> Issued Books Details</h1>
	<table border="1">
		<tr>
			<th>Call No.</th>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Mobile Number</th>
			<th>Issued Date</th>
			<th> Return Status </th>
		</tr>
		<% List<IssuedBook> list=(List<IssuedBook>) request.getAttribute("issuedBooks"); %>
		<% for(IssuedBook i:list){
		%>
			<tr>
				<td><%= i.getCallno() %> </td>
				<td> <%= i.getSid() %> </td>
				<td><%= i.getSname() %> </td>
				<td> <%= i.getMob() %></td>
				<td><%= i.getIssueDate() %> </td>
				<td><%= i.getReturnStatus() %></td>
			</tr>
			
		<% } %>

</body>
</html>