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
	<div class="row">
		<div class="col-sm">
			<i class="col-sm-2">Status:</i><strong>${status}</strong>
		</div>
	</div>
	<div class="row"> 
		<div class="col-sm">
			<i class="col-sm-2">Name:</i><strong>${name}</strong>
		</div>
	</div>
	<div class="row"> 
		<div class="col-sm">
			<i class="col-sm-2">Subject:</i><strong>${subject}</strong>
		</div>
	</div>
	<div class="row"> 
		<div class="col-sm">
			<i class="col-sm-2">Date:</i><strong>${date}</strong>
		</div>
	</div>
	<div class="row"> 
		<div class="col-sm">
			<i class="col-sm-2">Vehicle:</i><strong>${vehicle}</strong>
		</div>
	</div>
	<div class="row"> 
		<div class="col-sm-2">
			<i class="col-sm-2">Content</i> <p class="mt-1">${content}</p>
		</div>
	</div>
</div>
</body>
</html>