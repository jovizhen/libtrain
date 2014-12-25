<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Bulk Add Author</h3>
		<form action="bulkAddAuthorAction" method="post" enctype="multipart/form-data">
			<input type="file" name="authorsFile" placeholder="Upload File for Authors">
			<input type="submit"/>
		</form>

	</div>
</body>
</html>
