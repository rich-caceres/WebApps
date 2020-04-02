<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter List</title>
</head>
<body>
<c:forEach items= "${data}" var="greetings" }>
<h2>${greeting.name}</h2>
</c:forEach>
</body>
</html>