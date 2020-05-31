<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>List of Tickets</title>
</head>
<body>
<h1>Submitted Tickets</h1>
<p id="tick"></p>
<c:forEach items="${E1}" var="E1tickets">
 
		<td><a href=tickets?action=view&ticketId=${tickets.key}>${E1tickets.key} ${E1tickets.subject}</a></td>
		<td>${E1tickets.value.name}</td>
		<td>${E1tickets.value.vehicle}</td>	
	</c:forEach>
	
</body>
</html>