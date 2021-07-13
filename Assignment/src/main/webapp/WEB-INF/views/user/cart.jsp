<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<section class="main-content-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- BSTORE-BREADCRUMB START -->
				<div class="bstore-breadcrumb">
					<a href="index.html">HOME</a>
					<span><i class="fa fa-caret-right	"></i></span>
					<span>Your shopping cart</span>
				</div>
				<!-- BSTORE-BREADCRUMB END -->
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- SHOPPING-CART SUMMARY START -->
				<h2 class="page-title">Shopping-cart<span class="shop-pro-item"></span></h2>
				<!-- SHOPPING-CART SUMMARY END -->
			</div>	
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- SHOPING-CART-MENU START -->
				<div class="shoping-cart-menu">
					<ul class="step">
						<li class="step-current first">
							<span>01. Summary</span>
						</li>
						<li class="step-todo second">
							<span>02. Sign in</span>
						</li>
						<li class="step-todo third">
							<span>03. Address</span>
						</li>
						<li class="step-todo four">
							<span>04. Shipping</span>
						</li>
						<li class="step-todo last" id="step_end">
							<span>05. Payment</span>
						</li>
					</ul>									
				</div>
				<!-- SHOPING-CART-MENU END -->
				<!-- CART TABLE_BLOCK START -->
				<div class="table-responsive">
					<!-- TABLE START -->
					<table class="table table-bordered" id="cart-summary">
						<!-- TABLE HEADER START -->
						<thead>
							<tr>
								<th class="cart-product">Image</th>
								<th class="cart-avail text-center">Id</th>
								<th class="cart-avail text-center">Name</th>
								<th class="cart-avail text-center">Price</th>
								<th class="cart_quantity text-center">Quantity</th>
								<th class="cart-avail text-center">Amount</th>
								<th class="cart-total text-right">Total</th>
							</tr>
						</thead>
						<!-- TABLE HEADER END -->
						<!-- TABLE BODY START -->
						<tbody>	
							<c:forEach var="item" items="${CART_ITEMS}">
							<form action="/update" method="post">
							<input type="hidden" name="id" value="${item.idproduct}" />
								<tr>
									<td class="cart-product">
										<a href="#"><img alt="Blouse" src="/uploads/${item.image }"></a>
									</td>
									<td>${item.idproduct }</td>
									<td>${item.name }</td>
									<td>${item.price}$</td>
									<td class="cart_quantity text-center">
										<div class="cart-plus-minus-button">
											<input name="qty" value="${item.qty}" onblur="this.form.submit()" style="width: 50px;">
									</div>
									</td>
									<td class="cart-delete text-center">
										<span>
											<a href="/del/${item.idproduct}" class="cart_quantity_delete" title="Delete"><i class="fa fa-trash-o"></i></a>
										</span>
									</td>
									<td>${item.price*item.qty}$</td>
								</tr>
								</form>
							</c:forEach>
						</tbody>
						<!-- TABLE BODY END -->
						<!-- TABLE FOOTER START -->
						<tfoot>										
							<tr class="cart-total-price">
								<td class="cart_voucher" colspan="3" rowspan="4"></td>
								
							</tr>
							<tr>
								</tr>
							<tr>
								
							</tr>
							<tr>
								<td class="total-price-container text-right" colspan="3">
									<span>Total</span>
								</td>
								<td id="total-price-container" class="price" colspan="1">
									<span id="total-price">${TOTAL}$</span>
								</td>
							</tr>
							<a class="btn btn-primary btn-sm" href="/clear">Clear Cart</a> 
						</tfoot>		
						<!-- TABLE FOOTER END -->									
					</table>
					<!-- TABLE END -->
				</div>
				<!-- CART TABLE_BLOCK END -->
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="first_item primari-box mycartaddress-info">
					<!-- SINGLE ADDRESS START -->
					<ul class="address">
						<li>
							<h3 class="page-subheading box-subheading">
								Delivery address (BootExperts Office)
							</h3>
						</li>
						<li><span class="address_name">BootExperts</span></li>
						<li><span class="address_company">Web development Company</span></li>
						<li><span class="address_address1">Bonossri</span></li>
						<li><span class="address_address2">D-Block</span></li>
						<li><span class="">Rampura</span></li>
						<li><span class="">Dhaka</span></li>
						<li><span class="address_phone">+880 1735161598</span></li>
						<li><span class="address_phone_mobile">+880 1975161598</span></li>
					</ul>	
					<!-- SINGLE ADDRESS END -->
				</div>						
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="second_item primari-box mycartaddress-info">
					<!-- SINGLE ADDRESS START -->
					<ul class="address">
						<li>
							<h3 class="page-subheading box-subheading">
								Invoice address (BootExperts Home)
							</h3>
						</li>
						<li><span class="address_name">BootExperts</span></li>
						<li><span class="address_company">Web development Company</span></li>
						<li><span class="address_address1">Dhaka</span></li>
						<li><span class="address_address2">Bonossri</span></li>
						<li><span class="">Dhaka-1205</span></li>
						<li><span class="">Rampura</span></li>
						<li><span class="address_phone">+880 1735161598</span></li>
						<li><span class="address_phone_mobile">+880 1975161598</span></li>
					</ul>	
					<!-- SINGLE ADDRESS END -->
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- RETURNE-CONTINUE-SHOP START -->
				<div class="returne-continue-shop">
					<a href="index.html" class="continueshoping"><i class="fa fa-chevron-left"></i>Continue shopping</a>
					<a href="/buy-product" class="procedtocheckout">Proceed to checkout<i class="fa fa-chevron-right"></i></a>
				</div>	
				<!-- RETURNE-CONTINUE-SHOP END -->						
			</div>
		</div>
	</div>
</section>