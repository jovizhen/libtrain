<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Borrower</title>
<%@ include file="menu.jsp"%>
</head>
<body>
	<div class="container">
		<h3>Add Borrower</h3>
		<form action="addBorrowerAction" class="form-horizontal col-md-6" method="post">
			<div class="form-group">
				<label for="borrowerName">Name: </label>
				<spring:input type="text" placeholder="Enter Borrower Name" path="borrower.name" />
			</div>
			<div class="form-group">
				<label for="borrowerAddress">Address: </label>
				<spring:input type="text" placeholder="Enter Borrower Address" path="borrower.address" />
			</div>
			<div class="form-group">
				<label for="borrowerPhone">Phone: </label>
				<spring:input type="text" placeholder="Enter Borrower Phone" path="borrower.phone" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>