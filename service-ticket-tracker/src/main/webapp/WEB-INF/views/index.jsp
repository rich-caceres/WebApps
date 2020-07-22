<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Submit Ticket!</title>
</head>
<body>

 <nav class="navbar nav-pills navbar-expand-lg navbar-light bg-dark">
        <a class="navbar-brand" href="#">Fleet Maintenance Support</a>
        <button class="navbar-toggler bg-secondary" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon bg-secondary"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <a class="nav-item nav-link text-light active" href="#">Home</a>
                <a class="nav-item nav-link text-light" href="<c:url value='/listOfTickets'/>">Ticket List</a>
            </div>
        </div>
    </nav>

<div class= "container-fluid mt-1">
	<form action="<c:url value='submitTicket'/>" method="POST">
		<div class="form-group">
			<label for="UserName">Name</label> 
			<input type="text" class="form-control" id="UserName" name="name"><br> 
		</div>
		<div class="form-group">
			<label>Date</label>
			<input type="text" readonly class="form-control-plaintext" name="date" value="${date}">
		</div> 
		<div class="form-group">
			<label for="vehicle">Vehicle</label> 
			<input class="form-control" list="vehicles" name="vehicle" id= "vehicle">
				<datalist id="vehicles">
					<option value= "E1">
					<option value= "E2">
					<option value= "E4">
					<option value= "E5">
					<option value= "E6">
					<option value= "L1">
					<option value= "TL2">
				</datalist>
		</div>
		<div class="form-group">
			<label for="subjectInput">Subject</label> 
			<input class="form-control" type="text" id="subjectInput" name="subject"><br>
		</div>
		<div class="form-group"> 
			<label for="contentInput">Content</label>
			<textarea class="form-control" name="content" id="contentInput" rows="5" cols="30"></textarea>
		</div>
		<input class="btn btn-primary" type="submit" value="Submit Ticket" name="submitTicket">
	</form>
</div>
</body>
</html>