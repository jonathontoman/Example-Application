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
		<div class="row">
			<div class="col-md-4">
				<h2>Create Contact</h2>
				<p>Enter the details for a contact then press submit to save the
					contact.</p>
				<form method="post" action="createContact">
					<div class="form-group">
						<label for="firstname">First Name</label> <input type="text"
							class="form-control" placeholder="Enter between 1 and 100 characters" name="firstname" required pattern=".{1,100}">
					</div>
					<div class="form-group">
						<label for="lastname">Last Name</label> <input type="text"
							class="form-control" placeholder="Enter between 1 and 100 characters" name="lastname" required pattern=".{1,100}">
					</div>
					<div class="form-group">
						<label for="phonenumber">Phone Number</label> <input type="text"
							class="form-control" placeholder="Enter between 1 and 20 numbers" name="phonenumber" required pattern=".{1,20}">
					</div>
					<div class="form-group">
						<label for="streetaddress">Street Address</label> <input
							type="text" class="form-control" placeholder="Enter between 1 and 1000 characters"
							name="streetaddress" required pattern=".{1,1000}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-md-8">
				<h2>View And Delete Existing Users</h2>
				<p>Select any number of users from the list and press delete to
					delete them from the system</p>
				<form id="contactsForm" method="post" action="deleteContact">
					<table class="table">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Phone</th>
								<th>Street</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${contacts}" var="contact">
								<tr>
									<td>${contact.firstname}</td>
									<td>${contact.lastname}</td>
									<td>${contact.phonenumber}</td>
									<td>${contact.street}</td>
									<td><input type="checkbox" name="deleteSelection" value="${contact.id}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button type="submit" class="btn btn-default">Delete</button>
				</form>			
			</div>
		</div>
	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>