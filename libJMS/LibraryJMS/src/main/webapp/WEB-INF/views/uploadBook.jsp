<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Bulk Add Book</h3>
		<form action="bulkAddBookAction" method="post" enctype="multipart/form-data">
			<input type="file" name="booksFile" placeholder="Upload File for Books">
			<input type="submit"/>
		</form>

	</div>
</body>
</html>