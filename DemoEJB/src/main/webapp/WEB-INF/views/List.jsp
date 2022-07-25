<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
            <h2>List</h2>
        </div>
    </div>
    <div class="card-body">
        <div class="input-group col d-flex justify-content-end mb-3">
            <input type="text" class="" placeholder="Search">
            <div class="input-group-append">
                <button class="btn btn-success" type="submit">Go</button>
            </div>
        </div>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>User name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th class="text-center">Update</th>
                    <th class="text-center">Delete</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${accountList}" var="account" >
                <tr>
                    <td>${account.getId()}</td>
                    <td>${account.getUsername()}</td>
                    <td>${account.getPassword()}</td>
                    <td>${account.getEmail()}</td>
                    <td>${account.getPhone()}</td>
                    <td>${account.getAddress()}</td>
                    <td class="text-center">
                        <a href="/DemoEJB/Update?id=${account.getId()}" class="btn btn-warning"
                            role="button">Update</a>
                    </td>
                    <td class="text-center">
                        <a onclick="return Del('${account.getUsername()}')"
                            href="/DemoEJB/Delete?id=${account.getId()}" class="btn btn-danger"
                            role="button">Delete</a>
                    </td>
                </tr>
			</c:forEach>
            </tbody>
        </table>
        <a class="btn btn-success" href="/DemoEJB/Add">Add</a>
    </div>
</div>
<script>
function Del(name) {
    return confirm("Are you sure want to delete " + name + "?");
}
</script>
</body>
</html>