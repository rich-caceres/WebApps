<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Login!</title>
<link rel="stylesheet" type="text/css" href="resources/Style.css" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/aguafina-script:n4:default;brush-script-std:n4:default.js" type="text/javascript"></script>
</head>
<body id="body-back">
<header><h1>The Flight Booker</h1></header>
<div id= "first-div">
<i>${error}</i>
<form method= "POST" action= "/FlightBookingApp/login" >
<i>Username</i><br>
<input type="text" name="username"><br>
<i>Password</i><br>
<input type="password" name="password">
<input type="submit" value="Submit" name= "submit">
</form>
</div>
</body>
</html>