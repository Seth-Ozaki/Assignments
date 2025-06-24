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
<body class="bg-dark">
<div class="container">
	<h1>Heres Your Omikuji!</h1>
	<div class="card" style="width: 18rem;">
  <div class="card-body">
    <p class="card-text">In <c:out value="${ number }"/> years,
     you will live in <c:out value="${ city }"/> with
     <c:out value="${ name }"/> as your room mate,
     selling <c:out value="${ hobby }"/>  for a living.
     The next time you see a <c:out value="${ thing }"/>,
     you will have good luck.
     <c:out value="${ nice }"/>
    </p>
    <a href="/" class="btn btn-primary">Try again.</a>
  </div>
</div>
</div>
</body>
</html>