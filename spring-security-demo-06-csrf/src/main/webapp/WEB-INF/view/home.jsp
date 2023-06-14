<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2>My home page</h2>
	<hr>
	<p>Welcome to my home page!!!</p>
	
	<!-- add logout button with form -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
		
		<input type="submit" value="Logout"/>
		
	</form:form>
</body>
</html>