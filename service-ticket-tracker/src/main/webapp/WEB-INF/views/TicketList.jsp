<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<title>List of Tickets</title>
</head>
<body>
<h1>Submitted Tickets</h1>
<table id="table"></table>

<p id="JSONticks" hidden= "true">${ticket}</p>
	
</body>
</html>