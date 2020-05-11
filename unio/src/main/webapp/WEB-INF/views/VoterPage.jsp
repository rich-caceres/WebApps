<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="javascript" type="javascript" href="resources/jsp-nav-script.js" >
<title>Voting Page</title>
</head>
<body>
<div id="flip-tabs" >  
        <ul id="flip-navigation" >  
            <li class="selected"><a href="#" id="tab-0" >President</a></li>  
            <li><a href="#" id="tab-1" >Vice President</a></li>  
            <li><a href="#" id="tab-2" >Electoral board</a></li>
            <li><a href="#" if="tab-3">Trustee</a></li>  
        </ul>  
        <div id="flip-container" >  
            <div>  
                <!--President Voting content goes here-->  
            </div>  
            <div>  
                <!--Vice president voting content goes here-->  
            </div>  
            <div>  
                <!--Electoral Board Voting content goes here-->  
            </div> 
            <div>
            	<!-- Trustee Voting content goes here -->
            </div> 
        </div>  
    </div>  
</body>
</html>