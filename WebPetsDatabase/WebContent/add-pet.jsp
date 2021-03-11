<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a pet</title>
<link rel="stylesheet" type="text/css" href="mainStyle.css" />
</head>
<body>

<form action="addPetServlet" method="post">
Name: <input type ="text" name = "name">
Type of pet: <input type = "text" name = "type">
Adoption Date: <input type = "date" name = "adoptionDate">
Owner:
<select name = "id" id = "id">
<c:forEach items="${requestScope.allOwners}" var="currentOwner">
	<option value="${currentOwner.id}">${currentOwner.name}</option>
</c:forEach>
</select>
<input type ="submit" value = "Add pet" >

</form>
</body>
</html>