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
		<div style="display: flex; justify-content: flex-end;">
			<a href="/logout" class="btn btn-warning">Log-Out</a>
		</div>
		<h1>
			Hello
			<c:out value="${name}">
			</c:out>
			ID:
			<c:out value="${id}"></c:out>
		</h1>
	</div>
	<div class="container">
		<h1>All Books</h1>


		<table class="table text-light">
			<thead>
				<tr>
					<th scope="col">Team Name</th>
					<th scope="col">Skill (1-5)</th>
					<th scope="col">Team Size</th>
					<th scope="col">Game Day</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td><a href="/teams/${team.id}"><c:out value="${team.teamName}" /></a></td>
						<td><c:out value="${team.skill}" /></td>
						<td><c:out value="${team.teamPlayers.size()}" />/9</td>
						<td><c:out value="${team.gameDay}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/teams/new" class="btn btn-warning">Add Team+</a>
	</div>
</body>
</html>