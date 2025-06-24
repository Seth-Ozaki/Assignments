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
<div class="container d-flex justify-content-end">
<a href="/home" class="btn btn-warning">Home</a>
</div>
<div class="container">
<h1><c:out value="${team.teamName}"></c:out></h1>
<h3>Team name: <c:out value="${team.teamName}"></c:out></h3>
<h3>Created by: <c:out value="${team.owner.userName}"></c:out></h3>
<h3>Skill Level: <c:out value="${team.skill}"></c:out></h3>
<h3>Game Day: <c:out value="${team.gameDay}"></c:out></h3>
<h3>Players on this team:</h3>
<c:forEach var="player" items="${team.teamPlayers}">
	<h5><c:out value="${player.playerName}"></c:out></h5>
</c:forEach>
<div class="column align-items-start d-flex gap-1">
<c:if test="${team.owner.userName == name}">
<a href="/teams/edit/${team.id}" class="btn btn-info">Edit</a>
<form action="/teams/delete/${team.id}" method="post">
<input type="hidden" name="_method" value="delete"> <input
	type="submit" value="Delete" class="btn btn-danger">
</form>
</c:if>
<div>
<h4>Add Player</h4>
	<form:form action="/players/new" method="post" modelAttribute="newPlayer">
		<div class="mb-3">
			<form:label class="form-label" path="playerName">Name:</form:label>
			<form:input class="form-control" path="playerName"/>
			<form:errors path="playerName"/>
		</div>
		<form:hidden path="team" value="${team.id}"/>
		<input type="submit" value="Submit"  class="btn btn-warning"/>
	</form:form>

</div>
</div>
</div>
</body>
</html>