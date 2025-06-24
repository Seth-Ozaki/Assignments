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
		<div class="container d-md-flex justify-content-md-end ">
			<a class="btn btn-warning" href="/dojos" role="button">Home</a>
		</div>
		<div class="container">
			<h1>All <c:out value="${dojo.dojoName}s"></c:out> Ninja </h1>
			<table class="table text-light">
				<thead>
					<tr>			
						<th scope="col">Name</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${ninjas}">
						<tr>
							<td><c:out value="${ninja.firstName} ${ninja.lastName}" /></td>
							<td><c:out value="${ninja.age}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>