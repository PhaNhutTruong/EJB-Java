<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"></link>
<title>Demo EJB</title>
</head>
<body>
	<div class="container-fluid">
    <div class="card">
        <div class="card-header col d-flex justify-content-center">
            <h2>Update Account</h2>
        </div>
        <div class="card-body">
            <form action="/DemoEJB/Update" method="post">
            	<div class="form-group">
                    <label for="">ID</label>
                    <input type="text" name = "id" value="${account.getId()}"  class="form-control" readonly>
                </div>
            	
               <div class="form-group">
                    <label for="">User Name</label>
                    <input type="text" name = "username" value="${account.getUsername()}"  class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="">Password</label>
                    <input type="text" name = "password" value="${account.getPassword()}" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" name = "email" value="${account.getEmail()}" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="">Phone</label>
                    <input type="text" name = "phone" value="${account.getPhone()}" class="form-control" required>
                </div>

				 <div class="form-group">
                    <label for="">Address</label>
                    <input type="text" name = "address" value="${account.getAddress()}" class="form-control" required>
                </div>
                
                <button class="btn btn-primary" type=submit value="submit">Accept</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>