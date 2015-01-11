<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<%@ include file="menu.jsp"%>
</head>
<body>
<div class="container">
<h2>Welcome to admin Page!</h2>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
</div>
</body>
</html>