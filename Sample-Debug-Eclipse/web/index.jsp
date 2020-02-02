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
			int num3 = num1 * num2;
			System.out.print("this is java code using scriplets in jsp" + "4*6 = " + num3);
			%>
	</body>
</html>
