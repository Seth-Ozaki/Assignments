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
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-dark">
	<h1 class ="text-light">Fruit Store</h1>
	<table class="table table-dark">
	<c:forEach var="oneFruit" items="${fruits}">
	<tr>
		<td>
        <p style ="color:${oneFruit.getColor()}"><c:out value="${oneFruit.getName()}"></c:out></p>
		</td>
		<td>	<p><c:out value="${oneFruit.getPrice()}"></c:out></p>
		</td>
	</tr>
    </c:forEach>
	</table>
</body>
</html>