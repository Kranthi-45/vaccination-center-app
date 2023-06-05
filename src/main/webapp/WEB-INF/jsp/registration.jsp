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
		<h1 class="text-center">Admin Registration Form</h1>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
				<form:form method="POST" action="registration" modelAttribute="user" id="registrationForm">     <!-- action="branch" mapping should be same in controller class also -->
					Name:<form:input  path="name" class="form-control" /> 
					Email:<form:input path="email" class="form-control" /> 
					Password:<form:input path="password" class="form-control" /> <br/>
					
					 <!-- Path variable (hidden input) -->
					<input type=submit name="registration" class="btn btn-success" value="Register"  />    
					
				</form:form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>