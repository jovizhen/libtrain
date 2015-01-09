<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
<%@ include file="menu.jsp"%>
</head>
<body>
	<div class="container">
		<h3>Add Book</h3>
		<form action="addBookAction" method="post" class="form-horizontal col-md-6">
			<div class="form-group">
				<label for="title">Title: </label>
				<spring:input type="text" placeholder="Enter Title" path="book.title" />
			</div>
			<div class="form-group">
				<label for="author">Author: </label>
				<spring:select path="book.author.authorId">
					<spring:option value="1" label="--- Select ---" />
					<spring:options items="${authorList}" itemValue="authorId" itemLabel="authorName" />
				</spring:select>
			</div>
			<div class="form-group">
				<label for="publisher">Publisher: </label>
				<spring:select path="book.publisher.publisherId">
					<spring:option value="1" label="--- Select ---" />
					<spring:options items="${publisherList}" itemValue="publisherId" itemLabel="publisherName" />
				</spring:select>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>