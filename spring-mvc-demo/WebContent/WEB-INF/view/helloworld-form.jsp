<!DOCTYPE html>
<html>
<head>
	<title>Hello World - Input Form</title>
</head>
<body>
	<form action="processFormVersionThree" method="GET">
		<input type="text" name="studentName"
			placeholder="What's your name?">
			
		<input type="submit">
		
	</form>
	<br>
	<a href="${pageContext.request.contextPath}">Go back to Home Page</a>
</body>
</html>