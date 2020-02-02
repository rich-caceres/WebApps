<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Ticket</title>
</head>
<body>

	<h1>Create a Ticket</h1>
	<!-- Starts a form that is used to post data to the servlet tickets -->
	<form method="POST" action="tickets" enctype="multipart/form-data">
	<!-- This next input line calls create in the switch block and creates the new tickets-->
	<input type="hidden" name="action" value="create">
	
		<h3>Your Name</h3>
		<input type="text" name="customerName">

		<h3>Subject</h3>
		<input type="text" name="subject">

		<h3>Body</h3>
		<textarea name="body" rows="5" cols="30"> </textarea>

		<h3>
			<b>Attachments</b>
		</h3>
		<input type="file" name="file1">
		<input type ="submit" value="Submit">
	</form>



</body>
</html>