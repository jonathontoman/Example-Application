<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>My Contacts Sample Application</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>My Contacts Sample Application</h1>
			<p>This is an example application to show how to create users,
				display users and delete users from a simple java web application</p>
		</div>
	</div>
	<div class="container">
		<p>Please Log In (hint user = "admin" password = "admin")</p>
		<form method="post" action="login">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" placeholder="Enter username ... "
					name="username">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" placeholder="Enter password..." name="password">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>