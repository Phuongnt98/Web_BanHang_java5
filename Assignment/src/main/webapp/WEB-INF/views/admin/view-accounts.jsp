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
		<h2>List Users</h2>
		<a href="/account/register" class="btn btn-primary">Add Users</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Photo</th>
					<th>UserName</th>
					<th>Password</th>
					<th>FullName</th>
					<th>Email</th>
					<th>Activated</th>
					<th>Admin</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ac" items="${ACCOUNT}">
					<tr>
							<td align="center"><img
								src="/uploads/${ac.photo }"
								width="40" height="40" /></td>
							<td>${ac.username }</td>
							<td>${ac.password }</td>
							<td>${ac.fullname }</td>
							<td>${ac.email }</td>
							<td>${ac.activated?"Online":"Offline" }</td>
							<td>${ac.admin?"Admin":"User" }</td>
							<td><a class="btn btn-primary btn-sm"
								href="/account/register/${ac.username}">Edit</a> <a
								class="btn btn-danger btn-sm" href="?btnDel=&username=${ac.username}">Delete</a></td>
						</tr>
				</c:forEach>
				
			</tbody>
			
		</table>
		<%-- <nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item"><a class="page-link" href="/account/views/page?p=0">First</a></li>
				    <li class="page-item"><a class="page-link" href="/account/views/page?p=${ACCOUNT.number - 1}">Previous</a></li>
				    <li class="page-item"><a class="page-link" href="/account/views/page?p=${ACCOUNT.number + 1}">Next</a></li>
				    <li class="page-item"><a class="page-link" href="/account/views/page?p=${ACCOUNT.totalPages - 1}">Last</a></li>
				  </ul>
				</nav> --%>
	</div>
</body>
</html>

