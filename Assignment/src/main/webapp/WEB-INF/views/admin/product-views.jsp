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
		<h2>List Product</h2>
		<a href="/product/managerproduct" class="btn btn-primary">Add Product</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>PHOTO</th>
					<th><a href="views?field=idproduct">IDPRODUCT</a></th>
					<th><a href="views?field=category.idcategory">IDCATEGORY</a></th>
					<th><a href="views?field=name">NAME</a></th>
					<th><a href="views?field=price">PRICE</a></th>
					<th><a href="views?field=createdate">Create Date</a></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>	
						<c:forEach var="p" items="${PRODUCT.content}">
							<tr>
								<td align="center"><img src="/uploads/${p.image}"
								width="40" height="40" /></td>
								<td>${p.idproduct }</td>
								<td>${p.category.idcategory}</td>
								<td>${p.name }</td>
								<td>${p.price }$</td>
								<td>${p.createdate }</td>
								<td><a class="btn btn-primary btn-sm" href="/product/managerproduct/${p.idproduct }">Edit</a>| 
								<a class="btn btn-danger btn-sm" href="/product/viewsProduct?btnDel=&idproduct=${p.idproduct}">Delete</a></td>
							</tr>
						</c:forEach>
				
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="/product/views/page?p=0">First</a></li>
		    <li class="page-item"><a class="page-link" href="/product/views/page?p=${PRODUCT.number - 1}">Previous</a></li>
		    <li class="page-item"><a class="page-link"> ${PRODUCT.number + 1} / ${PRODUCT.totalPages} </a></li>
		    <li class="page-item"><a class="page-link" href="/product/views/page?p=${PRODUCT.number + 1}">Next</a></li>
		    <li class="page-item"><a class="page-link" href="/product/views/page?p=${PRODUCT.totalPages - 1}">Last</a></li>
		  </ul>
		</nav> 
	</div>
</body>
</html>

