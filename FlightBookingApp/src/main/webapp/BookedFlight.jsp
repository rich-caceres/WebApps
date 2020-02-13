<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight is Booked!</title>
<link rel="stylesheet" type="text/css" href="Style.css" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div id= "main-div">
      <div id="first-div">
            <h2>Your Booked flight</h2>

          <p>You're departing location will be ${startLoc} on ${startDate} with ${traveler} travelers.</p>
          <p>Your return date is ${endDate} and you will arrive at ${endLoc}</p>

        </div>
      <div id="second-div">
            <h2>Support Requests</h2>
          <form method="POST" action="BookingServlet" enctype="multipart/form-data">
          
              <span style="font-family: Constantia, 'Lucida Bright', 'DejaVu Serif', Georgia, serif">
              <input type="hidden" name="action" value="support">
              <i>Name</i><br>
              <input type="text" name="name"><br>

              <i>Request Subject</i><br>
              <input type="text" name="subject"><br>

              <i>Body</i><br>
              <textarea name="body" rows="5" cols="30"> </textarea><br>

              <i>Attachments</i><br>
              <input type="file" name="file1">
              <input type="submit" name= "subSup"><br>
              <br>
              </span>
        </form>
        <span style="font-family: Constantia, 'Lucida Bright', 'DejaVu Serif', Georgia, serif">
          <footer><i>${response}</i></footer>

        </span></div>
    </div>
	

</body>
</html>