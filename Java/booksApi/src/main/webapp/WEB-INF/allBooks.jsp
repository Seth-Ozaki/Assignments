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
	<h1>All Books</h1>
	<table class="table text-light">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Title</th>
				<th scope="col">Language</th>
				<th scope="col">Page count</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<th scope="row"><c:out value="${book.getId()}"/></th>
				<td><a href="http://localhost:8080/books/${book.getId()}"><c:out value="${book.getTitle()}"/></a></td>
				<td><c:out value="${book.getLanguage()}"/></td>
				<td><c:out value="${book.getPageCount()}"/></td>				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>