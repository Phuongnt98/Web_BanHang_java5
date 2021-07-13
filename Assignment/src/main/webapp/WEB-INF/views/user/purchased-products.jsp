<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<table class="table table-bordered">
			<thead>
                          <tr>
                              <th class="product-thumbnail">Image</th>
                              <th class="product-name">Product</th>
                              <th class="product-price">Price</th>
                              <th class="product-quantity">Quantity</th>
                              <th class="product-subtotal">Amount Total</th>
                          </tr>
                      </thead>
			<tbody>
                      	<c:forEach var="listOrderDetail" items="${listOrderDetail}">
                      		<form action="/update" method="post">
                       		<tr>
                               <td class="product-thumbnail">
                                   <a href="#"><img style="width: 45px; height: 45px" src="uploads/${listOrderDetail.product.image}" alt="cart-image" /></a>
                               </td>
                               <td class="product-name"><a href="#"></a>${listOrderDetail.product.name}</td>
                               <td class="product-price"><span class="amount">${listOrderDetail.price}$</span></td>
                               <td class="product-quantity"> <span>${listOrderDetail.quantity}</span></td>
                               <td class="product-subtotal">${listOrderDetail.price * listOrderDetail.quantity}$</td>
                            </tr>
                           </form>
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
<%-- <div class="cart-main-area ptb-100 ptb-sm-60">
  <div class="container">
      <div class="row">
          <div class="col-md-12 col-sm-12">
              <div class="table-content table-responsive mb-45">
                  <table>
                      <thead>
                          <tr>
                              <th class="product-thumbnail">Image</th>
                              <th class="product-name">Product</th>
                              <th class="product-price">Price</th>
                              <th class="product-quantity">Quantity</th>
                              <th class="product-subtotal">Amount Total</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="listOrderDetail" items="${listOrderDetail}">
                      		<form action="/update" method="post">
                       		<tr>
                               <td class="product-thumbnail">
                                   <a href="#"><img style="width: 45px; height: 45px" src="uploads/${listOrderDetail.product.image}" alt="cart-image" /></a>
                               </td>
                               <td class="product-name"><a href="#"></a>${listOrderDetail.product.name}</td>
                               <td class="product-price"><span class="amount">${listOrderDetail.price}$</span></td>
                               <td class="product-quantity"> <span>${listOrderDetail.quantity}</span></td>
                               <td class="product-subtotal">${listOrderDetail.price * listOrderDetail.quantity}$</td>
                            </tr>
                           </form>
                      	</c:forEach>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
    </div>
</div> --%>