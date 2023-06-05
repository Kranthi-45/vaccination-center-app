<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>            <!--taglib directive for <forEach> tag  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- this taglib for "form:form" tags  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Center</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8"><br>
		   <table class="table table-bordered table-striped table-hover">
		         <thead style="text-decoration:underline">
		         	<th><a href="/citizens">Citizens</a></th>
		         	<th><a href="/vaccinationcenter">Vaccination Centers</a></th>
		         	<th><a href="/login"> Logout</a></th>
		         	<th>Welcome, ${user.name}</th>
		         </thead>
					<tr>

					</tr>                                
		  </table>
		
		</div>
		<div class="col-md-2"></div>
	</div>
		<br>
		<br>
		<h2>Citizens</h2> <br>
		<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		   <table class="table table-bordered table-striped table-hover">
		         <thead>
		         	<th>ID</th>
		         	<th>Name</th>
		         	<th>City</th>
		         	<th>No. of Doses</th>
		         	<th>Vaccination Status</th>
		         	<th>Vaccination Center</th>
		         	<th>Actions</th>
		         </thead>
		         <tbody>
		          <tr style="text-align:right">
<!-- 		          		<input type=submit name="add" class="btn btn-success" value="Add" />  
 -->		          		
 					<a href="/addCitizens" class="btn btn-primary">Add New Citizens</a>
		          		
		          </tr>
		          <tr></tr>
				<c:forEach var="c" items="${citizensList}">    
					<tr>
						<td> ${c.id}</td>
						<td> ${c.name}</td>
						<td> ${c.city}</td>
						<td> ${c.noOfDoses}</td>
						<td> ${c.vaccinationStatus}</td>
						<td> ${c.vaccinationCenter}</td>
						
					    <td>
					     	<a href="/selectCitizen?cid=${c.id }">Edit</a>
					    	<a href="/deleteCitizen?cid=${c.id }">Delete</a>
					    	<a href="/viewCitizen?cid=${c.id }">View</a>
					    </td>
					</tr>                                
        		</c:forEach>
        		</tbody>
		  </table>
		
		</div>
		<div class="col-md-2"></div>
	</div>
	
	
</body>
</html>