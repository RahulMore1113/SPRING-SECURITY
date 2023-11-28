<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOW BALANCE</title>
</head>
<body>
	<h1 style="color: blue; text-align: center;">SHOW BALANCE PAGE</h1>
	<b> BALANCE :: <%=new Random().nextInt(100000)%>
	</b>
	<br />
	<a href="./">HOME</a>
	<br />
	<a href="logout">LOGOUT</a>
</body>
</html>