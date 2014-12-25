<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">

		<h3>Bulk Add Branch</h3>
		<form action="bulkAddBranchAction" method="post" enctype="multipart/form-data">
			<input type="file" name="branchesFile" placeholder="Upload File for Branches">
			<input type="submit"/>
		</form>

	</div>
</body>
</html>