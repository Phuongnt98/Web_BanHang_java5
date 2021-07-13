<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
<h2 style="margin-top: 20px; margin-left: 20px">Manage-Categories</h2>
<hr style="width: 1500px">
<form:form action="" method="post" enctype="multipart/data" modelAttribute="category">
	<div class="categories-list-edition">
	
		<div class="input-group flex-nowrap" style="width: 600px; margin-left: 20px; margin-top: 20px;">
		  <form:input path="idCategory" type="text" class="form-control" placeholder="Id Category" />
		</div>
		<form:errors path="idCategory" cssClass="cssErorr"></form:errors>
		
		<div class="input-group flex-nowrap" style="width: 600px; margin-left: 20px; margin-top: 20px;">
		  <form:input path="name" type="text" class="form-control" placeholder="Name Category" />
		</div>
		<form:errors path="name" cssClass="cssErorr"></form:errors>
		
		<div style="margin-top: 30px; margin-left: 160px">
			<button type="submit" class="btn btn-success" formaction="/save-category" style="width: 90px; margin-left: 10px">Save</button>
			<button type="submit" class="btn btn-danger" formaction="/delete-category" style="width: 90px; margin-left: 10px">Delete</button>
			<button type="submit" class="btn btn-warning" formaction="/reset-category" style="width: 90px; margin-left: 10px">Reset</button>
		</div>
		
	</div>
</form:form>
<div class="categories-list">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">
	      	<a href="/manager-categories?sortby=idcategory&sort=asc"><i class="fa fa-sort-amount-up"></i></a>
	      	<label>ID</label>
	      	<a href="/manager-categories?sortby=idcategory&sort=desc"><i class="fa fa-sort-amount-down"></i></a>
	      </th>
	      <th scope="col">
	      	<a href="/manager-categories?sortby=name&sort=asc"><i class="fa fa-sort-amount-up"></i></a>
	      	<label>Name Category</label>
	      	<a href="/manager-categories?sortby=name&sort=desc"><i class="fa fa-sort-amount-down"></i></a>
	      </th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
    	<c:forEach var="listCategory" items="${listCategory}">
			<tr>
				<th>${listCategory.idcategory}</th>
				<th>${listCategory.name}</th>
				<th><a style="width: 80px" class="btn btn-primary" href="/edit-category/${listCategory.idcategory}">Edit</a></th>
			</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>
<nav aria-label="Page navigation example" style="margin-left: 200px; margin-top: 50px">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="/prev-category" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#" >
        <span aria-hidden="true">${page}</span>
      </a>
    </li>
    <li class="page-item">
      <a class="page-link" href="/next-category" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</body>
</html> --%>