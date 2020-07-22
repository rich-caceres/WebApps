<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Selected Ticket</title>
</head>
<body>
<nav class="navbar nav-pills navbar-expand-lg navbar-light bg-dark">
        <a class="navbar-brand" href="#">Fleet Maintenance Support</a>
        <button class="navbar-toggler bg-secondary" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon bg-secondary"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            	<a class="nav-item nav-link text-light" href="<c:url value='/'/>">Home</a>
                <a class="nav-item nav-link text-light" href="<c:url value='/listOfTickets'/>">Ticket List</a>
            </div>
        </div>
    </nav>

<div class= "container-fluid mt-1">
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