<!DOCTYPE html>
<html>
	<head>
		<title>Sample Debug</title>
		
		<style>
@import url('https://fonts.googleapis.com/css?family=Bangers&display=swap');
		</style>
		
	</head>
	<body style="font-family: 'Bangers', cursive;">
		Your application has successfully deployed!<br />
		<br />
		Java runtime version: <%= System.getProperty("java.version") %>
		
		<p>HI!!! This is my first web application, used as a test bed to try new stuff!</p>
		<%  int num1 = 4;
			int num2 = 6;
			int num3 = num1 * num2;%>
		
		<p>This is an example of java code in JSP file using scriplets, this is bad practice</p><br>
		<p>6*4 = <%= num3 %> </p>	
		
		<p>Next, is an example of the same problem without using scriplets and instead using the servlet to do the work</p><br>
		<p>6*4 = ${num3}</p><br>
		<p>This is better practice and much more secure</p>
		
		
	</body>
</html>
