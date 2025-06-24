<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
<h1>Title: <c:out value="${book.getTitle()}"></c:out></h1>
<h3>Description: <c:out value="${book.getDescription()}"></c:out></h3>
<h3>Language: <c:out value="${book.getLanguage()}"></c:out></h3>
<h3>Pages: <c:out value="${book.getPageCount()}"></c:out></h3>
<a href="http://localhost:8080/books"> All books</a>
</div>
</body>
</html>