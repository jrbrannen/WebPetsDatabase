<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>Owner List</title>
		
	</head>
	
	<body>
	
		<form method="post" action="ownerNavigationServlet">
		
			<table>
			
				<c:forEach items="${requestScope.allOwners}" var="currentOwners">
				<tr>
				
					<td><input type="radio" name="id" value="${currentOwners.id}"></td>
					
					<td><h4>Owner: ${currentOwners.name}</h4></td>
					
				</tr>
					
					
						<!--<c:forEach var="owner" items="${currentowner.listofPets}">
						
						<tr><td></td><td colspan= "3">$listVal.name}</td><tr>
						
						</c:forEach>-->
							
				</c:forEach>
				
			</table>
			
			<input type ="submit" value ="edit" name="doThisToOwner">
			
			<input type ="submit" value ="delete" name="doThisToOwner">
			
			<input type="submit" value ="add" name ="doThisToOwner">
			
		</form>
		
		<a href=" "></a>
	
		<a href="index.html">Home Page</a>
	
	</body>
	
</html>