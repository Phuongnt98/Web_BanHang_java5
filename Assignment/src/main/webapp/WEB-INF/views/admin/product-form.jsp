<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style type="text/css">
        .error{
        	color:red;
        }</style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
                <div class="col-sm-12">
                    <h2>Thông tin Product</h2>
                    <form:form action="/product/SaveOrUpdate" modelAttribute="PRODUCT" method="post" enctype="multipart/form-data">
                        
                        <div class="form-group">
                            <label>ID Product</label>
                            <form:input type="text" class="form-control" path="idproduct"  placeholder="Enter idproduct"/>
                        	<form:errors path="idproduct" cssClass="error"></form:errors>
                        </div>
                        <div class="form-group">
                            <label>ID category</label>
                            <input type="text" class="form-control" value="${category.idcategory}" name="id-category"  placeholder="Enter category"/>
                
                        </div>
                        <div class="form-group">
                            <label>Name:</label>
                            <form:input type="text" class="form-control" path="name"  placeholder="Enter name"/>
                        	<form:errors path="name" cssClass="error"></form:errors>
                        </div>
                        <div class="form-group">
                            <label>Price</label>
                            <form:input type="text" class="form-control" path="price"  placeholder="Enter price"/>
                        	<form:errors path="price" cssClass="error"></form:errors>
                        </div>
                        
                      
                       <div class="form-group">
                            <label>Photo</label>
                            <input type="file" class="form-control" name="image-product" accept="image/JPG" />
                        </div>
                        
                        <form:button type="submit" class="btn btn-primary">Submit</form:button>
                        <a href="/product/viewsProduct" class="btn btn-primary">Display Product</a>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>

