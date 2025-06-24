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
		<h1>All Items</h1>
		<table class="table text-light align-middle">
			<thead>
				<tr>
					<th scope="col">Item</th>
					<th scope="col">Store</th>
					<th scope="col">Price</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach var="item" items="${items}">
					<tr class="position-relative">
						<td><a href="/items/${item.getId()}"><c:out
									value="${item.getItemName()}" /></a></td>
						<td><c:out value="${item.getStoreName()}" /></td>
						<td>$<c:out value="${item.getPrice()}" /></td>
						<td><a href="items/edit/${item.getId()}"> Edit</a></td>
						<td>
							<form action="items/delete/${item.getId()}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<form:form action="/items" method="post" modelAttribute="newItem">
			<div class="mb-3">
				<form:label class="form-label" path="itemName">Item Name:</form:label>
				<form:input class="form-control" path="itemName" />
				<form:errors path="itemName" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="storeName">Store Name:</form:label>
				<form:input class="form-control" path="storeName" />
				<form:errors path="storeName" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="price">Price:</form:label>
				<form:input type="number" step="0.01" class="form-control" path="price" />
				<form:errors path="price" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Description:</form:label>
				<form:input class="form-control" path="description" />
				<form:errors path="description" />
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>