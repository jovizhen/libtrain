<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Bulk Add Publisher</h3>
		<form action="bulkAddPublisherAction" method="post" enctype="multipart/form-data">
			<input type="file" name="pubsFile" placeholder="Upload File for Publishers">
			<input type="submit"/>
		</form>

	</div>
</body>
</html>
