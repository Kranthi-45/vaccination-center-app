<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>            <!--taglib directive for <forEach> tag  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  <!-- this taglib for "form:form" tags  -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.example.demo.entity.pacUser" %>
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
		         	<%-- <th>Welcome, ${user.name}</th> --%>
		         	<th>Welcome, <%= ((pacUser) session.getAttribute("user")).getName() %></th>
		         </thead>
					<tr>

					</tr>                                
		  </table>
		
		</div>
		<div class="col-md-2"></div>
	</div>
		<br>
		<br>
		<h2 style="text-align:center">Centers</h2> <br>
		<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		   <table class="table table-bordered table-striped table-hover">
		         <thead>
		         	<th>ID</th>
		         	<th>Name</th>
		         	<th>City</th>
		         	<th>Actions</th>
		         </thead>
		         <tbody>
		          <tr style="text-align:right">	          		
 					<a href="/addVaccinationCenter" class="btn btn-primary">Add new Center</a>         		
		          </tr>
		          <tr></tr>
				<c:forEach var="v" items="${vaccinationCentersList}">    
					<tr>
						<td> ${v.id}</td>
						<td> ${v.name}</td>
						<td> ${v.city}</td>
					    <td>
					     	<a href="/select?vid=${v.id }">Edit</a>
					    	<a href="/delete?vid=${v.id }">Delete</a>
					    	<a href="/view?vid=${v.id }">View</a>
					    	
					    </td>
					</tr>                                
        		</c:forEach>
        		</tbody>
		  </table>
		<p style="text-align:center">Total ${fn:length(vaccinationCentersList)} Vaccination Centers found.</p>
		</div>
		<div class="col-md-2"></div>
	</div>
	
	
</body>
</html>