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
	<div class="container d-flex justify-content-between gap-2">
		<c:if test="${isAdmin == 1}">
		<h1>Hey Gizmo!</h1>
		</c:if>
		<c:if test="${isAdmin != 1}">
		<h1>Gizmos Art</h1>
		</c:if>
		<div>
		<c:if test="${isAdmin == 1}">
		<a href="/items/new" class="btn btn-primary">Add-Item+</a>
		</c:if>
		
		<a href="/logout" class="btn btn-warning">Log-Out</a>
		</div>
	</div>
	<div class="container d-flex gap-2">
		<c:forEach var="item" items="${items}">
			<div class="card bg-dark" style="width: 10rem;">
				<img src="https://mymodernmet.com/wp/wp-content/uploads/2020/08/raccoon-paintings-5.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">
						<c:out value="${item.itemName}"></c:out>
					</h5>
					<p class="card-text">$<c:out value="${item.price}"></c:out></p>
					<a href="/items/${item.id}" class="btn btn-info">Learn More</a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>