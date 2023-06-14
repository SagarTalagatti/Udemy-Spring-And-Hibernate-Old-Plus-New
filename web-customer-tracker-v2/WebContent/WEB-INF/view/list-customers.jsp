<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.luv2code.springdemo.util.SortUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

		<div id="container">

			<div id="content">

				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
				<!--  add a search box -->
				<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />

					<input type="submit" value="Search" class="add-button" />
				</form:form>
				<c:url var="sortByFirstName" value="/customer/list">
					<c:param name="sortField" value="<%=Integer.toString(SortUtils.FIRST_NAME.getValue())%>"></c:param>
				</c:url>
				<c:url var="sortByLastName" value="/customer/list">
					<c:param name="sortField" value="<%=Integer.toString(SortUtils.LAST_NAME.getValue())%>"></c:param>
				</c:url>
				<c:url var="sortByEmail" value="/customer/list">
					<c:param name="sortField" value="<%=Integer.toString(SortUtils.EMAIL.getValue())%>"></c:param>
				</c:url>
				<table>
					<tr>
						<th><a href="${sortByFirstName}">First Name</a></th>
						<th><a href="${sortByLastName}">Last Name</a></th>
						<th><a href="${sortByEmail}">Email</a></th>
						<th>Action</th>
					</tr>

					<!-- loop over and print customers -->
					<c:forEach var="customer" items="${customers}">

						<!-- construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<!-- construct a delete link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>

							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>
								| <a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

	</div>
</body>
</html>