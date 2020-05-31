<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
<a href="<c:url value='/listOfTickets'/>">Ticket List</a>
	<form action="<c:url value='submitTicket'/>" method="POST">
		<i>Name</i> <input type="text" name="name"><br> <i>Date</i>
		<input type="text" name="date" value="${date}"><br> <i>Vehicle</i> <input
			type="text" name="vehicle"><br> <i>Subject</i> <input
			type="text" name="subject"><br> <i>Content</i><br>
		<textarea name="content" rows="5" cols="30"></textarea>
		<input type="submit" value="Submit Ticket" name="submitTicket">
	</form>
</body>
</html>