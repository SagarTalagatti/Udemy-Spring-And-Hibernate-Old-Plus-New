<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
	<hr>
	<!-- display username and role -->
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- add a link to point to /leaders ... this is for managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Managers)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- add a link to point to /systems ... this is for admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admins)
		</p>
	</security:authorize>
	<!-- add logout button with form -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
		
		<input type="submit" value="Logout"/>
		
	</form:form>
</body>
</html>