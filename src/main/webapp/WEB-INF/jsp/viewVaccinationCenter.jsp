<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>            <!--taglib directive for <forEach> tag  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- this taglib for "form:form" tags  -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Vacination Center</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">View Vacination Center</h1>
	</div>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		   <table class="table table-bordered table-striped table-hover">
		         <thead>
		         	<th>ID</th>
		         	<th>City</th>
		         	<th>Name</th>
		         	<th></th>
		         </thead>
		   
					<tr>
						<td> ${viewVaccinationCenter.id}</td>
						<td>${viewVaccinationCenter.name}</td>
						<td>${viewVaccinationCenter.city}</td>						
					</tr>                                
		  </table>
		
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>