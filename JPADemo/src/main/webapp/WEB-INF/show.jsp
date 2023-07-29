<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Books</title>
</head>
<body>

	<h1><c:out value="${book.title}"/></h1>

	<p>Description: <c:out value="${book.description}"/></p>
	
	<p>Language: <c:out value="${book.language}"/></p>
	
	<p>Number of Pages: <c:out value="${book.numberOfPages}"/></p>
	
</body>
</html>