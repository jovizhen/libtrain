<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Bulk Add Borrower</h3>
		<form action="bulkAddBorrowerAction" method="post" enctype="multipart/form-data">
			<input type="file" name="borrowersFile" placeholder="Upload File for Borrowers">
			<input type="submit"/>
		</form>

	</div>
</body>
</html>