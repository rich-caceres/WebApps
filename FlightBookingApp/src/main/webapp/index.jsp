<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Booking</title>
        <link rel="stylesheet" type="text/css" href="Style.css" >
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <div id= "first-div">
        <h1>Book Your Flight!</h1>
        
        <form method= "POST" action="BookingServlet">
        
        <input type="hidden" name="action" value="create">
        <h4>Starting Location</h4>
        <input type="text" name="startLoc">
        
        <h4>Ending Location</h4>
        <input type="text" name="endLoc">
        
        <h4>Total Travelers</h4>
        <input type="text" name="travelers">
        
        <h4>Start Date</h4>
        <i>current Date: ${date}</i><br>
        <input type="date" name="startDate" value= ${date} min=${date}>
        
        <h4>End Date</h4>
        
        <input type= "date" name="endDate">
        <input type="submit" value="Submit">
        
        </form>
      </div>
      <div id="second-div">
      	<h1>Search Results</h1>
      <i>Search results placeholder</i>
      
      </div>
        
    </body>
</html>
