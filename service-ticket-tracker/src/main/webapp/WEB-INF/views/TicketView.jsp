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
<i>Name: </i>${name}
<br>
<br>
<i>Subject: </i>${subject}
<br>
<br>
<i>Date: </i>${date}
<br>
<br>
<i>Vehicle: </i>${vehicle}
<br>
<br>
<i>Content: </i><p>${content}</p>
</body>
</html>