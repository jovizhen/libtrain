<%
	String result = (String) request.getAttribute("result");
%>

<html>
<body>

<%@ include file="menu.jsp"%>
	<div class="container">

		<% if(result != null) { %>
			<p><%=result%></p>
		<% } %>
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>Welcome to Library Management System</h2>
			<p>This Library provides services to Borrowers who are interested in Reading books.</p>
		</div>

	</div>

</body>
</html>