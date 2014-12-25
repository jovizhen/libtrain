<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

<h3>Add Book</h3>
<form action="addBookAction" method="post">
	<input type="text" placeholder="Enter Title" name="title"/><br/>
	<spring:select path="book.author.authorId">
		<option>--Select Author--</option>
		<spring:options items="${authors}" itemLabel="authorName" itemValue="authorId" />
	</spring:select><br/>
	<spring:select path="book.publisher.publisherId">
		<option>--Select Publisher--</option>
		<spring:options items="${publishers}" itemLabel="name" itemValue="publisherId" />
	</spring:select><br/>
	<input type="submit"/>
</form>

</body>
</html>