<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/Style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script
	src="http://use.edgefonts.net/aguafina-script:n4:default;brush-script-std:n4:default.js"
	type="text/javascript"></script>
<title>New Profile</title>
</head>
<body id="body-back">
	<header>
		<h1>The Flight Booker</h1>
	</header>
	<div id="first-div">
		<i>${formError}</i>
		<form method="POST" action="/FlightBookingApp/loginNew">
			<i>Create a New User</i><br> <i>Name</i><br> <input
				type="text" value="" name="name"><br> <i>Username</i><br>
			<input type="text" value="" name="userName"><br> <i>Password</i><br>
			<input type="text" value="" name="password"> <input
				type="submit" value="Submit" name="submit"> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<form method="GET" action="<c:url value='login'/>">
			<input type="submit" value="Back" name="submit">
		</form>
	</div>
</body>
</html>