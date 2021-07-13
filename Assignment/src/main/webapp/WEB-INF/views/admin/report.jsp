<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h2 style="margin-top: 20px; margin-left: 20px">Report revenue</h2>
<hr style="width: 1500px">
<div style="width: 1000px; margin-left: 250px; margin-top: 50px">	
	<form action="/search-report" method="post">
		<div style="float: left">
			<select name="idcategory" aria-label="Default select example" style="width: 200px" class="form-select">
				<option value="">Danh mục( *tất cả )</option>
				<c:forEach var="listCategory" items="${listCategory}">
		    		<option value="${listCategory.idcategory}">${listCategory.name}</option>
		    	</c:forEach>
			</select>
		</div>
		<div class="input-group flex-nowrap" style="float: left; width: 250px; margin-left: 50px">
		  <label style="margin-right: 10px; margin-top: 5px">Từ ngày: </label><input type="date" value="01-01-2000" name="date1" class="form-control" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<div class="input-group flex-nowrap" style="float:left; width: 250px; margin-left: 20px">
		  <label style="margin-right: 10px; margin-top: 5px">Đến ngày: </label> <input type="date" value="20-08-2022" name="date2" class="form-control"  aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<button type="submit" style="margin-left: 20px" class="btn btn-primary">Tìm kiếm</button>
	</form>
</div>
<div class="user-list" style="margin-top: 100px">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Category</th>
	      <th scope="col">Product</th>
	      <th scope="col">Image</th>
	      <th scope="col">Price</th>
	      <th scope="col">Quantity</th>
	      <th scope="col">Price Total</th>
	      <th scope="col">Username</th>
	    </tr>
	  </thead>
	  <tbody>
    	<c:forEach var="listReport" items="${listReport}">
    		<tr>
		      <th scope="col">${listReport.nameCategory}</th>
		      <th scope="col">${listReport.nameProduct}</th>
		      <th scope="col"><img alt="" style="width: 45px" src="/uploads/${listReport.image}"></th>
		      <th scope="col">${listReport.price}$</th>
		      <th scope="col">${listReport.quantity}</th>
		      <th scope="col">${listReport.price * listReport.quantity}$</th>
		      <th scope="col">${listReport.username}
		    </tr>
    	</c:forEach>
	  </tbody>
	</table>
	<span style="margin-left: 450px; font-weight: bold; font-size: 20px">Tổng số lượng: ${quantityTotal}</span>
	<span style="font-weight: bold; margin-left: 40px; font-size: 20px">Tổng tiền: ${priceTotal}$</span>
</div>
 --%>