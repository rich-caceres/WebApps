<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Tickets</title>
</head>
<body>
<h1>Submitted Tickets</h1>
<c:forEach items="${tickets}" var="ticket">
		<td><a href=tickets?action=view&ticketId=${ticket.key}>${ticket.key}</a></td>
		<td>${datas.value.customerName}</td>
		<td>${datas.value.subject}</td>
	</c:forEach>
</body>
</html>