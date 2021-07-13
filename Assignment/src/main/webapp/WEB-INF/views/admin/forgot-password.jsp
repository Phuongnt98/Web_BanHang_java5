<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Forgot Password</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
                <div class="col-sm-12">
                    <h2>Forgot Password</h2>
                    <form action="/forgot-password" method="post">
                        <div class="form-group">
                            <label>UserName</label>
                            <input type="text" class="form-control" name="username" placeholder="Enter userName">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Confirm Change</button>
                        
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>