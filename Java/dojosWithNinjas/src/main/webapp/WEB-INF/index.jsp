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
	<div class="container" style="display: flex">

		<div class="container">
			<h1>New Dojo</h1>
			<form:form action="/dojos" method="post" modelAttribute="newDojo">
				<div class="mb-3">
					<form:label class="form-label" path="dojoName">Name:</form:label>
					<form:input class="form-control" path="dojoName" />
					<form:errors path="dojoName" />
				</div>
				<input type="submit" value="Submit" class="btn btn-warning" />
			</form:form>
		</div>

		<div class="container">
			<h1>Dojos</h1>
			<table class="table text-light">
				<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dojos}">
						<tr>
							<td><a class="btn btn-info" href="/dojos/${dojo.id}" role="button"><c:out value="${dojo.dojoName}" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="container d-grid gap-2 d-md-flex justify-content-md-end">
		<a class="btn btn-warning" href="/dojos/new/ninja" role="button">Become a Ninja!</a>
	</div>
</body>
</html>