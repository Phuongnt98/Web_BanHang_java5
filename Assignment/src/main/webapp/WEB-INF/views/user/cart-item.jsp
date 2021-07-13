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
		<h2>List Products</h2>
		<div class="rows">
			<div class="col-sm-9">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Image</th>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Amount</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${CART_ITEMS}">
							<form action="/shopping-cart/update" method="post">
								<input type="hidden" name="id" value="${item.idproduct}" />
							<tr>
								<td align="center"><img
								src="/uploads/${item.image }"
								width="40" height="40" /></td>
								<td>${item.idproduct }</td>
								<td>${item.name }</td>
								<td>${item.price}</td>
								<td><input name="qty" value="${item.qty}"
									onblur="this.form.submit()" style="width: 50px;"></td>
								<td>${item.price*item.qty}</td>
								<td><a class="btn btn-primary btn-sm"
									href="/shopping-cart/del/${item.idproduct}">Remove</a></td>
							</tr>
							</form>
						</c:forEach>


					</tbody>
				</table>
				<p>Tong Tien:${TOTAL}</p>
				<hr />
				<a class="btn btn-primary btn-sm" href="/shopping-cart/clear">Clear Cart</a> 
				<a class="btn btn-primary btn-sm" href="/shopping-cart/views/page">Add more</a>
			</div>
		</div>

	</div>
</body>
</html>