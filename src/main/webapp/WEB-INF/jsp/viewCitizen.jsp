<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>            <!--taglib directive for <forEach> tag  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- this taglib for "form:form" tags  -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Citizens</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">View Citizens</h1>
	</div>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		   <table class="table table-bordered table-striped table-hover">
		    <tbody>
		        <tr>
            		<td colspan="2" style="text-align:center"> <h3>${viewCitizen.name}</h3></td>
        		</tr>
        		<tr>
            		<th>ID</th>
            		<td>${viewCitizen.id}</td>
        		</tr>
        		<tr>
            		<th>City</th>
            		<td>${viewCitizen.city}</td>
        		</tr>
        		<tr>
            		<th>Number of Vaccines</th>
            		<td>${viewCitizen.noOfDoses}</td>
        		</tr>
        		<tr>
            		<th>Vaccination Status</th>
            		<td>${viewCitizen.vaccinationStatus}</td>
        		</tr>
        		<tr>
            		<th>Allocated Vaccination Center</th>
            		<td>${viewCitizen.vaccinationCenter}</td>
        		</tr>        		        		
    		</tbody>                               
		  </table>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>