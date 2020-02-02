<!-- Below is the declaration of JSTL also known as JSP standard tag library  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket</title>
</head>
<body>

	<!-- Using values sent from the TicketServlet.java file I populate the data in the ticket view -->
	<h1>Ticket # ${idString}</h1>
	<i><Strong>Customer Name: </Strong></i>
	<i>${customerName}</i>
	<br>
	<br>

	<i><strong>Subject: </strong></i>
	<i>${subject}</i>
	<h4>Body</h4>

	<p>${body}</p>
	<br>
		<!-- Using JSTL we move populate the list of attachments -->
	<c:forEach items="${attachments}" var="attachment">

		<i>Attachment</i>
		<br>
		<a
			href=tickets?action=download&ticketId=${idString}&attachment=${attachment.name}>${attachment.name}</a>
	</c:forEach>

	<br>
	<a href="tickets">Return to list tickets</a>

</body>
</html>