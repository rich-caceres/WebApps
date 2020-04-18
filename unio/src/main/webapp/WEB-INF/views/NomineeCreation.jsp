<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Users</p>
 <c:forEach items= "${users}" var="user">
 		<p>${user.name}</p>
 		<input type="checkbox" name= "nominee">
 </c:forEach>
</body>
</html>