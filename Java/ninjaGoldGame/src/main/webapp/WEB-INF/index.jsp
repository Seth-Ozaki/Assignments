<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
		<h1>
			Your Gold :
			<c:out value="${gold}" />
		</h1>

		<div style="display: flex; gap: 20px; margin-bottom: 20px">

			<div class="card text-dark" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">Farm</h5>
					<p class="card-text">(earns 10-20 gold)</p>
					<form action="/choice" method="post">
						<input type="hidden" value="1" name="choice">
						<button type="submit" class="btn btn-primary">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="card text-dark" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">cave</h5>
					<p class="card-text">(earns 5-10 gold)</p>
					<form action="/choice" method="post">
						<input type="hidden" value="2" name="choice">
						<button type="submit" class="btn btn-primary">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="card text-dark" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">House</h5>
					<p class="card-text">(earns 2-5 gold)</p>
					<form action="/choice" method="post">
						<input type="hidden" value="3" name="choice">
						<button type="submit" class="btn btn-primary">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="card text-dark" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">Quest</h5>
					<p class="card-text">(earns/takes 0-50 gold)</p>
					<form action="/choice" method="post">
						<input type="hidden" value="4" name="choice">
						<button type="submit" class="btn btn-primary">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="card text-dark" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">Spa</h5>
					<p class="card-text">(takes 5-20 gold)</p>
					<form action="/choice" method="post">
						<input type="hidden" value="5" name="choice">
						<button type="submit" class="btn btn-primary">Relax!</button>
					</form>
				</div>
			</div>
		</div>
		<div>
			<a href="/reset"><button type="button" class="btn btn-primary">
					Reset the game</button></a>
		</div>
		
		<div>
		<h2>Activities:</h2>
		<div style="height:200px">
		<c:forEach var="quest" items="${activity}">
		<c:choose>
		<c:when test="${fn:contains(quest, 'spent') }">
		 <p style="color:red;"><c:out value="${quest}"></c:out></p>
		</c:when>
		<c:when test="${fn:contains(quest, 'earned') }">
		 <p style="color:green;"><c:out value="${quest}"></c:out></p>
		</c:when>
		</c:choose>
    </c:forEach>
		</div>
		</div>
	</div>
	
</body>
</html>