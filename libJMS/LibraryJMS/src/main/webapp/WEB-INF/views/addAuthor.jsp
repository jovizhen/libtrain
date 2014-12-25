<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Add Author</h3>
		<form action="addAuthorAction" method="post">
			<spring:input type="text" placeholder="Enter Author's Name" path="author.authorName"/>
			<input type="submit"/>
		</form>

	</div>
</body>
</html>