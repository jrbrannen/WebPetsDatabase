<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Edit An Owner</title>
	</head>
	
	<body>
	
		<form action = "editOwnerServlet" method="post">
	
		Name: <input type="text" name="name" value="${ownerToEdit.name}">
		
		<input type="hidden" name="id" value="${ownerToEdit.id}">
		
		<input type="submit" value="Save Edited Owner">
		
	</form>
	
	</body>
	
</html>