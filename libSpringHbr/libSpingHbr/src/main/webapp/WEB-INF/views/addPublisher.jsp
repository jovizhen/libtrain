<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new publisher</title>
<%@ include file="menu.jsp"%>
</head>
<body>
<div class="container">
	<h3>Add Publisher</h3>
		<form action="addPublisherAction" class="form-horizontal col-md-6"
			method="post" role="form">
			<div class="form-group">
				<label for="publisherName">Name: </label>
				<spring:input type="text" cssClass="form_control" placeholder="Enter Author's Name" path="publisher.publisherName"/>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>