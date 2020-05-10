<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter List</title>
</head>
<body>
	<h2>Sign In</h2>
	<br>
	<h3>Username</h3>
	<input type="text" name="username">
	<br>
	<h3>Password</h3>
	<input type="text" name="password">
	<br>
	<a href="<c:url value="/login"/>">sign in</a>
	<a href="<c:url  value="/CreateUser"/> ">Create User</a>
</body>
</html>