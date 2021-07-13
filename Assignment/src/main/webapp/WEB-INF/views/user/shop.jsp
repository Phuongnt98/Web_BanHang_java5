<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
					<span><i class="fa fa-caret-right"></i></span>
					<span>Women</span>
				</div>
				<!-- BSTORE-BREADCRUMB END -->
				
					<!-- SINGLE SIDEBAR ENABLED FILTERS END -->
					<!-- SINGLE SIDEBAR CATEGORIES START -->
					
					<!-- SINGLE SIDEBAR CATEGORIES END -->
					<!-- SINGLE SIDEBAR AVAILABILITY START -->
					
					<!-- SINGLE SIDEBAR AVAILABILITY END -->
					<!-- SINGLE SIDEBAR CONDITION START -->
					
					<!-- SINGLE SIDEBAR CONDITION END -->
					<!-- SINGLE SIDEBAR MANUFACTURER START -->
					
					<!-- SINGLE SIDEBAR MANUFACTURER END -->
					<!-- SINGLE SIDEBAR PRICE START -->
					
					<!-- SINGLE SIDEBAR PRICE END -->
					<!-- SINGLE SIDEBAR SIZE START -->
					
					<!-- SINGLE SIDEBAR SIZE END -->
					<!-- SINGLE SIDEBAR COLOR START -->
					
					<!-- SINGLE SIDEBAR COLOR END -->
					<!-- SINGLE SIDEBAR COMPOSITIONS START -->
					
					<!-- SINGLE SIDEBAR COMPOSITIONS END -->
					<!-- SINGLE SIDEBAR STYLES START -->
					
					<!-- SINGLE SIDEBAR STYLES END -->
					<!-- SINGLE SIDEBAR PROPERTIES START -->
					
					<!-- SINGLE SIDEBAR PROPERTIES END -->
				</div>
				<!-- PRODUCT-LEFT-SIDEBAR END -->
				<!-- SINGLE SIDEBAR TAG START -->
				
				<!-- SINGLE SIDEBAR TAG END -->
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
				<div class="right-all-product">
					<!-- PRODUCT-CATEGORY-HEADER START -->
					<div class="product-category-header">
						<div class="category-header-image">
							<img src="/img/category-header.jpg" alt="category-header" />
							<div class="category-header-text">
								<h2>Women </h2>
								<strong>You will find here all woman fashion collections.</strong>
								<p>This category includes all the basics of your wardrobe and much more:<br /> shoes, accessories, printed t-shirts, feminine dresses, women's jeans!</p>
							</div>									
						</div>
					</div>
					<!-- PRODUCT-CATEGORY-HEADER END -->
					<div class="product-category-title">
						<!-- PRODUCT-CATEGORY-TITLE START -->
						
						<!-- PRODUCT-CATEGORY-TITLE END -->
					</div>
					<div class="product-shooting-area">
						<div class="product-shooting-bar">
							<!-- SHOORT-BY START -->
							<div class="shoort-by">
								<label for="productShort">Sort by</label>
								<div class="short-select-option">
									<select name="sortby" id="productShort">
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
										
									</select>												
								</div>
							</div>
							<!-- SHOORT-BY END -->
							<!-- SHOW-PAGE START -->
							
							<!-- SHOW-PAGE END -->
							<!-- VIEW-SYSTEAM START -->
							<div class="view-systeam">
								
							</div>
							<!-- VIEW-SYSTEAM END -->
						</div>
						<!-- PRODUCT-SHOOTING-RESULT START -->
						<div class="product-shooting-result">
							<form action="#">
							</form>
							<div class="showing-item">
							</div>
							<div class="showing-next-prev">
						<ul class="pagination-bar">
							<li >
								<a href="/views/page?p=0" ><i class="fa fa-chevron-left"></i>First</a>
							</li>
							<li >
								<a href="/views/page?p=${PRODUCT.number - 1}" ><i class="fa fa-chevron-left"></i>Previous</a>
							</li>
							<li>
								<a >${PRODUCT.number + 1} / ${PRODUCT.totalPages}</a>
							</li>
							<li>
								<a href="/views/page?p=${PRODUCT.number + 1}" >Next<i class="fa fa-chevron-right"></i></a>
							</li>
							<li>
								<a href="views/page?p=${PRODUCT.totalPages - 1}" >Last<i class="fa fa-chevron-right"></i></a>
							</li>
						</ul>
						<form action="#">
						</form>
					</div>
						</div>
						<!-- PRODUCT-SHOOTING-RESULT END -->
					</div>
				</div>
				<!-- ALL GATEGORY-PRODUCT START -->
				<div class="all-gategory-product">
					<div class="row">
						<ul class="gategory-product">
							<!-- SINGLE ITEM START -->
							<c:forEach var="p" items="${PRODUCT.content}"> 
								<li class="gategory-product-list col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="single-product-item">
										<div class="product-image">
											<a href="single-product.html"><img src="/uploads/${p.image}" alt="product-image" /></a>
											<a href="single-product.html" class="new-mark-box">new</a>
											<div class="overlay-content">
												<ul>
													
													<li><a href="/add/${p.idproduct }" title="Quick view"><i class="fa fa-shopping-cart"></i></a></li>
													
												</ul>
											</div>
										</div>
										<div class="product-info">
											<div class="customar-comments-box">
												<div class="rating-box">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half-empty"></i>
												</div>
												
											</div>
											<a href="single-product.html">${p.name}</a>
											<div class="price-box">
												<span class="price">${p.price}</span>
											</div>
										</div>
									</div>									
								</li>	
							</c:forEach>					
						</ul>
					</div>
				</div>
				<!-- ALL GATEGORY-PRODUCT END -->
				<!-- PRODUCT-SHOOTING-RESULT START -->
				<div class="product-shooting-result product-shooting-result-border">
					<form action="#">
						
					</form>
					<div class="showing-item">
					</div>
					<div class="showing-next-prev">
						<ul class="pagination-bar">
							<li >
								<a href="/views/page?p=0" ><i class="fa fa-chevron-left"></i>First</a>
							</li>
							<li >
								<a href="/views/page?p=${PRODUCT.number - 1}" ><i class="fa fa-chevron-left"></i>Previous</a>
							</li>
							<li>
								<a >${PRODUCT.number + 1} / ${PRODUCT.totalPages}</a>
							</li>
							<li>
								<a href="/views/page?p=${PRODUCT.number + 1}" >Next<i class="fa fa-chevron-right"></i></a>
							</li>
							<li>
								<a href="/views/page?p=${PRODUCT.totalPages - 1}" >Last<i class="fa fa-chevron-right"></i></a>
							</li>
						</ul>
						<form action="#">
						</form>
					</div>
				</div>	
				<!-- PRODUCT-SHOOTING-RESULT END -->
			</div>
		</div>
	</div>
</section>