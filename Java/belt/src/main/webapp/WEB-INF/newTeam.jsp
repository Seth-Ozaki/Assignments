<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!-- Formatting Tags -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body class="bg-dark text-light">
<div class="container">
	<h1>New Team</h1>
	<form:form action="/teams/new" method="post" modelAttribute="newTeam">
		<div class="mb-3">
			<form:label class="form-label" path="teamName">Team Name:</form:label>
			<form:input class="form-control" path="teamName"/>
			<form:errors path="teamName"/>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="skill">Skill level:</form:label>
			<form:select class="form-select" path="skill">
					<c:forEach var="i" begin="1" end="5">
						<form:option value="${i}"><c:out value="${i}" /></form:option>
					</c:forEach>
			</form:select>
		</div> 
		<div class="mb-3">
			<form:label class="form-label" path="gameDay">Game Day:</form:label>
			<form:input class="form-control" path="gameDay"/>
			<form:errors path="gameDay"/>
		</div>
		<form:hidden path="owner" value="${id}"/>
		<input type="submit" value="Submit"  class="btn btn-warning"/>
		<a href="/home" class="btn btn-warning">Cancel</a>
	</form:form>

</div>
</body>
</html>