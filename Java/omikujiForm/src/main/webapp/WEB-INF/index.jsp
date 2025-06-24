<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="/submit" method="post">
			<div class="mb-3">
				<label class="form-label">Select a number between 5-25</label> 
				<select
					class="form-select" name="number">
					<option selected>Choose...</option>
					<c:forEach var="i" begin="5" end="25">
						<option value="${i}"><c:out value="${i}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label class="form-label">The name of any city</label> 
				<input type="text" class="form-control" name="city">
			</div>
			<div class="mb-3">
				<label class="form-label">The name of any person</label> 
				<input type="text" class="form-control" name="name">
			</div>
			<div class="mb-3">
				<label class="form-label">Professional endeavor or hobby</label> 
				<input type="text" class="form-control" name="hobby">
			</div>
			<div class="mb-3">
				<label class="form-label">Any living thing</label> 
				<input type="text" class="form-control" name="thing">
			</div>
			<div class="mb-3">
				<label class="form-label">Say something nice</label> 
				<input type="text" class="form-control" name="nice">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>