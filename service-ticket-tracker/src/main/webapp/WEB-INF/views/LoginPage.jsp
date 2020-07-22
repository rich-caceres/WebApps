<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<title>Login!</title>
</head>
<body>
	 <nav class="navbar nav-pills navbar-expand-lg navbar-light bg-dark">
        <a class="navbar-brand" href="#">Fleet Maintenance Support</a>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            </div>
        </div>
    </nav>

<div class="containter-fluid mt-2">

	<h3 class="text-center">Login</h3>
	
	<form action="<c:url value='login'/>" method="POST">
		<div class="form-group row pl-2">
			<label for="usernameInput" class="col-sm-1 col-form-label">Username</label>
			<div class="col-sm-5">
 				<input type="text" class="form-control" id="usernameInput" name= "username">
 			</div>
 		</div>
 		<div class="form-group row pl-2">
 			<label for="passwordInput" class="col-sm-1 col-form-label">Password</label>
 			<div class="col-sm-5">
 				<input type="password" class="form-control" id="passwordInput" name= "password">
 			</div>
 		</div>
 		<input type="submit" class="btn btn-primary ml-2 mb-2" value="Login" name="submit">
	</form>
	<a href="<c:url value='createUser'/>">
		<button class="btn btn-primary ml-2"  name="submit">New User</button>
	</a>
</div>
</body>
</html>