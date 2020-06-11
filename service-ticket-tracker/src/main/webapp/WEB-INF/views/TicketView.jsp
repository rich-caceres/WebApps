<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selected Ticket</title>
</head>
<body>
<h1>Selected Ticket</h1>
<i>Status: </i><strong>${status}</strong>
<br>
<i>Name: </i><strong>${name}</strong>
<br>
<br>
<i>Subject: </i><strong>${subject}</strong>
<br>
<br>
<i>Date: </i><strong>${date}</strong>
<br>
<br>
<i>Vehicle: </i><strong>${vehicle}</strong>
<br>
<br>
<i>Content: </i><p>${content}</p>
</body>
</html>