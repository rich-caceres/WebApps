<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Profile</title>
</head>
<body>
<form method = "POST" action="/FlightBookingApp/createUser">
<i>Name</i>
<input type="text" name = "name">
<i>Username</i>
<input type="text" name= "userName">
<i>Password</i>
<input type= "text" name= "password">
<input type= "submit" value= "Submit" name="submit">
</form>

</body>
</html>