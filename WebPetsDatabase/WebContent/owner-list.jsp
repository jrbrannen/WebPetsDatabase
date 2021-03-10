<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>Owner List</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css" />
		
	</head>
	
	<body>
	
		<form method="post" action="ownerNavServlet">
		
			<table>
			
				<c:forEach items="${requestScope.allOwners}" var="currentOwners">
				<tr>
				
					<td><input type="radio" name="id" value="${currentOwners.id}"></td>
					
					<td><h4>Owner: ${currentOwners.name}</h4></td>
					
				</tr>
					
						<!--  -->
					
						<c:forEach var="pet" items="${currentOwners.pet}">
						
						<tr><td></td><td>Pet: ${pet.name}, is a ${pet.type}, adopted on ${pet.adoptionDate}</td></tr>
						
						</c:forEach>
						
						
							
				</c:forEach>
				
			</table>
			
			<input type ="submit" value ="Edit An Owner" name="doThisToOwner">
			
			<input type ="submit" value ="Delete An Owner" name="doThisToOwner">
			
			<input type="submit" value ="Add An Owner" name ="doThisToOwner">
			
			
		</form>
		
		<p><a href="addPetPageServlet">Add a pet</a></p>
	
		<p><a href="index.html">Back To Home Page</a></p>
	
	</body>
	
</html>