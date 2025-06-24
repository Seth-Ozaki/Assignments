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
		<div class="container d-grid gap-2 d-md-flex justify-content-md-end">
			<a class="btn btn-warning" href="/dojos" role="button">Home</a>
		</div>
		<div class="container">
	<form:form action="/dojos/new/ninja" method="post" modelAttribute="newNinja">
		<div class="mb-3">
			<form:label class="form-label" path="dojo">Dojo:</form:label>
			<form:select class="form-select" path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}"><c:out value="${dojo.dojoName}" /></form:option>
					</c:forEach>
			</form:select>
			<form:errors path="dojo"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="firstName">First Name:</form:label>
			<form:input class="form-control" path="firstName"/>
			<form:errors path="firstName"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="lastName">Last Name:</form:label>
			<form:input class="form-control" path="lastName"/>
			<form:errors path="lastName"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="age">Age:</form:label>
			<form:input class="form-control" type="number" path="age"/>
			<form:errors path="age"/>
		</div>
		<input type="submit" value="Submit"  class="btn btn-primary"/>
	</form:form>
	</div>
	</div>
</body>
</html>