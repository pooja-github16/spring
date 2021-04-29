<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.elibrary.model.Book, java.util.*,com.elibrary.dao.BookDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
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
  		<a href="">Home</a>
  		<a href="add_book">Add Book</a>
 		 <a class="active" href="view_book">View Book</a>
 		 <a href="issue_book">Issue Book</a>
 		 <a href="view_issued_book">View Issued Book</a>
 		 <a href="return_book_form">Return Book</a>
 		 <a href="librarian_logout">Log out</a>
	</div>
		<h1> Books Details</h1>
	<table border="1">
		<tr>
			<th>Call No.</th>
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Publisher</th>
			<th>quantity</th>
			<th> Issued </th>
			<th> Delete</th>
		</tr>
	<%
		List<Book> books =(List<Book>)request.getAttribute("books");
		for(Book b:books){
	%>
	<tr>
			<td> <%=b.getCallno() %></td>
			<td> <%= b.getName() %></td>
			<td> <%= b.getAuthor() %></td>
			<td> <%= b.getPublisher() %></td>
			<td> <%= b.getQuantity() %></td>
			<td><%= b.getIssued() %></td>
			<td> <a href="delete_book?id=<%=b.getId()%>"><button>Delete</button></a>
		</tr>
	<% } %>
	
	
</body>
</html>
