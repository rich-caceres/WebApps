<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<title>List of Tickets</title>
</head>
<body>
<h1>Submitted Tickets</h1>
<c:forEach items="${tickets}" var="ticket">
<c:set var="vehicle" value="${ticket.value.vehicle}"></c:set>
 <c:if test="${vehicle = 'e2'}">
 <h3>Engine 2</h3>
		<td><a href=tickets?action=view&ticketId=${ticket.key}>${ticket.key} ${ticket.value.subject}</a></td>
		<td>${ticket.value.name}</td>
		<td>${ticket.value.vehicle}</td>
		</c:if>	
	</c:forEach>
	<p id="tickets"></p>
</body>
</html>