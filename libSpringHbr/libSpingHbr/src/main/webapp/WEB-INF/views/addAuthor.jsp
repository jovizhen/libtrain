<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>
<%@ include file="menu.jsp"%>
</head>
<body>
	<div class="container">
	<h3>Add Author</h3>
		<form action="addAuthorAction" class="form-horizontal col-md-6"
			method="post" role="form">
			<div class="form-group">
				<label for="authorName">Name: </label>
				<spring:input type="text" class="form_control" placeholder="Enter Author's Name" path="author.authorName"/>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>