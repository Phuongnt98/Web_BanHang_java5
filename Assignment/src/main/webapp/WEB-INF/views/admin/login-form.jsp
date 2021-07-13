<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
                <div class="col-sm-12">
                    <h2>Login</h2>
                    <form action="login" method="post">
                        <div class="form-group">
                            <label>UserName</label>
                            <input type="text" class="form-control" name="username" value="${username}"  placeholder="Enter userName">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" class="form-control" name="password" value="${password}" placeholder="Enter password">
                        </div>
                        <div class="checkbox">
                        <lable><input type = "checkbox" name="chkemember"> Remember me</lable>
                        </div>
                        <p style = "color: red"> ${MESSAGE}</p>
                        
                        <button type="submit" class="btn btn-primary">Submit</button>
                    	<p style = "margin:10px; font-size: 16px;"><a href="/account/register">Register</a></p>
                    	<p style = "margin:10px; font-size: 16px;"><a href="/quen-mat-khau">Forgot Password </a></p>
                        
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>