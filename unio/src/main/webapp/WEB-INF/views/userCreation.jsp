<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<p>Name</p>
	<input type="text" placeholder= "Enter name" name= "name"><br>
	<p>Password</p>
	<input type= "text" placeholder= "Enter password" name = "password"><br>
	<a href= "<c:url value="/CreateVoter*"/>">Create User</a>
	<a href= "<c:url value="/back"/>">Back</a>
</body>
</html> 