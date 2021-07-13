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
                    <h2>Thông tin Category</h2>
                    <form:form action="/save-category" modelAttribute="category" method="post" enctype="multipart/form-data">
                        
                        <div class="form-group">
                            <label>ID Category</label>
                            <form:input type="text" class="form-control"  path="idcategory"  placeholder="Enter category"/>
                            <form:errors path="idcategory" cssClass="error"></form:errors>
                		</div>
                        <div class="form-group">
                            <label>Name</label>
                            <form:input type="text" class="form-control"  path="name"  placeholder="Enter name"/>
                            <form:errors path="name" cssClass="error"></form:errors>
                        </div>
                        
                        <form:button type="submit" class="btn btn-primary">Submit</form:button>
                        <a href="/manager-categories" class="btn btn-primary">Display Category</a>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>

