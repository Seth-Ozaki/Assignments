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
<body>
<h1 style="display: flex;justify-content: center;">Welcome User</h1>
<h2 style="display: flex;justify-content: center;"><a  href="http://localhost:8080/count">count+1</a></h2>
<h2 style="display: flex;justify-content: center;"><a  href="http://localhost:8080/countTwo">count+2</a></h2>
<h2 style="display: flex;justify-content: center;"><a  href="http://localhost:8080/reset">reset</a></h2>
</body>
</html>