<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom login page</title>
<head>
 <title>Custom Login Page</title>
 <link rel="stylesheet" type="text/css" href="css/demo.css">
</head>
</head>
<body>
	<h3>My Custom Login Page</h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
		
		<!-- check for login error -->
		<c:if test="${param.error!=null}">
			<i class="failed">Sorry! You entered an invalid username/password.</i>
		</c:if>		
		
		<p>
			User name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />		
	</form:form>
</body>
</html>