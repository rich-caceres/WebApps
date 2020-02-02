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
<title>Ticket List</title>
</head>
<body>

	<h2>Tickets</h2>


	<a href="NewTicket.jsp">Create Ticket</a>
	<br>
	<br>
	<br>

	<h3>List of Tickets</h3>

	<table border="1" width="50%">

		<!-- loop created to loop through all ticket data to show on the main page of tickets-->
		<c:forEach items="${data}" var="datas">

			<tr>

				<td><a href=tickets?action=view&ticketId=${datas.key}>${datas.key}</a></td>
				<td>${datas.value.customerName}</td>
				<td>${datas.value.subject}</td>


			</tr>
		</c:forEach>
	</table>

</body>
</html>