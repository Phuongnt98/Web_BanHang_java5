<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>List Category</h2>
		<a href="" class="btn btn-primary">Add Category</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>IDCATEGORY</th>
					<th>NAME</th>
					
				</tr>
			</thead>
			<tbody>	
						<c:forEach var="c" items="${listCategory}">
							<tr>
								
								<td>${c.idcategory}</td>
								<td>${c.name }</td>
								
								<td><a class="btn btn-primary btn-sm" href="/edit-category/${c.idcategory }">Edit</a>| 
								<a class="btn btn-danger btn-sm" href="/delete-category?idcategory=${c.idcategory}">Delete</a></td>
							</tr>
						</c:forEach>
				
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="/prev-category">Previous</a></li>
		    <li class="page-item"><a class="page-link"> ${page} </a></li>
		    <li class="page-item"><a class="page-link" href="/next-category">Next</a></li>
		  </ul>
		</nav> 
	</div>
</body>
</html>
