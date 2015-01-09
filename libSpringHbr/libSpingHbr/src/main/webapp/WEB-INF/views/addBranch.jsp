<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<%@ include file="menu.jsp" %>
</head>
<body>
<div class="container">

<h3>Add Branch</h3>
		<form action="addBranchAction" class="form-horizontal col-md-6"
			method="post" role="form">
			<div class="form-group">
			<label for="branchName">Name: </label>
				<spring:input type="text" placeholder="Enter Branch's Name" path="branch.branchName"/>
			</div>
			<div class="form-group">
			<label for="branchAddress">Address: </label>
				<spring:input type="text" placeholder="Enter Branch's Address" path="branch.branchAddress"/>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
</div>
</body>
</html>