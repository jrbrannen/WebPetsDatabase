<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Add a pet</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css" />
		
		<script>
		
			function validate(){
				if(document.addPet.name.value == ""){
					alert("Please enter the pet's name!");
					document.addPet.name.focus();
					return false;
				}
				
				if(document.addPet.type.value == ""){
					alert("Please choose a type of pet!");
					document.addPet.type.focus();
					return false;
				}
				
				if(document.addPet.adoptionDate.value == ""){
					alert("Please enter an adoption date!");
					document.addPet.adoptionDate.focus();
					return false;
				}
				
				let format = /^\d{4}\-\d{1,2}\-\d{1,2}$/;
				if(!addPet.adoptionDate.value.match(format)){
					alert(addPet.adoptionDate.value + " Is not a valid date format\n Format needs to be YYYY-MM-DD");
					document.addPet.adoptionDate.focus();
					return false;
				}
				return true;
			}
		
		</script>
		
	</head>
	
	<body>
	
		<form action="addPetServlet" name="addPet" onsubmit = "return(validate())" method="post">
		Name: <input type ="text" name = "name">
		Type of pet: <input type = "text" name = "type">
		Adoption Date: <input type = "date" name = "adoptionDate" placeholder= YYYY-MM-DD>
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