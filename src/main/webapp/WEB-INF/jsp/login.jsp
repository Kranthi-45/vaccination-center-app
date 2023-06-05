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
		<h1 class="text-center">Login Form</h1>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
				<form:form method="POST" action="login" modelAttribute="user" id="loginForm">
					UserName:<form:input  path="name" class="form-control" /> 
					Password:<form:input path="password" class="form-control" /> <br/>
					
					 <!-- Path variable (hidden input) -->
					<input type=submit name="login" class="btn btn-success" value="login" />    
					 <a href="/registration" class="btn btn-primary">Register</a>			 					
				</form:form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>