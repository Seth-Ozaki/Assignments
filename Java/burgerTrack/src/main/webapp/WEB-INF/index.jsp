<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Formatting Tags -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
</head>
<body class="bg-dark text-light">
	<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table text-light">
			<thead>
				<tr>
					<th scope="col">Burger Name</th>
					<th scope="col">Restraurant Name</th>
					<th scope="col">Rating (out of 5)</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
						<td><c:out value="${burger.getBurgerName()}" /></td>
						<td><c:out value="${burger.getRestaurantName()}" /></td>
						<td><c:out value="${burger.getRating()}" /></td>
						<td><a href="/burgers/edit/${burger.getId()}"> Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
	<form:form action="/burgers" method="post" modelAttribute="newBurger">
		<div class="mb-3">
			<form:label class="form-label" path="burgerName">Burger Name:</form:label>
			<form:input class="form-control" path="burgerName"/>
			<form:errors path="burgerName"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="restaurantName">Restaurant Name:</form:label>
			<form:input class="form-control" path="restaurantName"/>
			<form:errors path="restaurantName"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="notes">Notes:</form:label>
			<form:input class="form-control" path="notes"/>
			<form:errors path="notes"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="rating">Rating:</form:label>
			<form:select class="form-select" path="rating">
					<c:forEach var="i" begin="1" end="5">
						<form:option value="${i}"><c:out value="${i}" /></form:option>
					</c:forEach>
			</form:select>
			<form:errors path="rating"/>
		</div>
		<input type="submit" value="Submit"  class="btn btn-primary"/>
	</form:form>
	</div>
</body>
</html>


























