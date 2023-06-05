<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>            <!--taglib directive for <forEach> tag  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- this taglib for "form:form" tags  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<c:choose>
        	<c:when test="${not empty addCitizen.id}">
				<h1 class="text-center">Edit Citizen</h1>
        	</c:when>
        	<c:otherwise>
            	<!-- Render ID field only for update operation -->
				<h1 class="text-center">Add New Citizen</h1>
        	</c:otherwise>
    	</c:choose>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
				<form:form method="POST" action="addNewCitizen" modelAttribute="addCitizen" id="addCitizenForm">     <!-- action="branch" mapping should be same in controller class also -->
            		<form:input type="hidden" name="id" path="id" value="${addCitizen.id}" class="form-control" />
   					
					Citizen Name:<form:input  path="name" class="form-control" /> 
					Citizen City:<form:input path="city" class="form-control" /> 
					Number of Doses:<form:input  path="noOfDoses" class="form-control" /> 
					Vaccination Status:<form:input path="vaccinationStatus" class="form-control" /> 
					Vaccination Center:<form:input  path="vaccinationCenter" class="form-control" /> 
					 <!-- Path variable (hidden input) -->   
					<c:choose>
        				<c:when test="${not empty addCitizen.id}">
            				<input type=submit name="modify" class="btn btn-warning" value="Submit"  />    
        				</c:when>
        				<c:otherwise>
            			<!-- Render ID field only for update operation -->
            			<div>
         					<input type=submit name="add" class="btn btn-success" value="Submit"  />    
         				</div>
        				</c:otherwise>
    				</c:choose>
				</form:form>
		</div>
		<div class="col-md-4"></div>
	</div>
	
		<script>
     function prepareModify() {
        var id = document.getElementById("id").value; // Assuming bid field contains the ID value
        document.getElementById("id").value = id; // Set the ID value in the hidden input   
 		document.getElementById("addVaccinationCenterForm").submit(); // Submit the form
    }
</script>
</body>
</html>