<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Selected Ticket</title>
</head>
<body>
<div class= "container-fluid">
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
</div>
</body>
</html>