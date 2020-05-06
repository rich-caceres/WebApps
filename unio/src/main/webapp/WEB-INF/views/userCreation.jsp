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
<form method= "POST" action="<c:url value='/CreateVoter*'/>">
	<p>Name</p>
	<input type="text" placeholder= "Enter name" name= "name"><br>
	<p>Password</p>
	<input type= "text" placeholder= "Enter password" name = "password"><br>
	<input type="submit" value="Create User">
</form>
	<a href= "<c:url value="/back"/>">Back</a>
</body>
</html> 