<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight is Booked!</title>
</head>
<body>

<h2>Your Booked flight</h2>
<div id="first-div">

<p>You're departing location will be ${startLoc} on ${startDate} with ${traveler} travelers.</p>
<p>Your return date is ${endDate} and you will arrive at ${endLoc}</p>

</div>
<div id="second-div">
<h2>Support Requests</h2>
<form>
<input type="hidden" name="action" value="support">
<i>Name</i><br>
<input type="text" name="name"><br>

<i>Request Subject</i><br>
<input type="text" name="subject"><br>

<i>Body</i><br>
<textarea name="body" rows="5" cols="30"> </textarea>

<i>Attachments</i><br>
<input type="file" name="file1">
<input type="submit" name= "subSup"><br>
<br>
</form>
<i>${response}</i>

</div>


</body>
</html>