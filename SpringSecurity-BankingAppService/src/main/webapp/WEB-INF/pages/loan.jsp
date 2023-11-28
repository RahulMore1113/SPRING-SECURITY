<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOAN AMOUNT</title>
</head>
<body>
	<h1 style="color: blue; text-align: center;">
		LOAN APPROVAL PAGE <br /> <br />
	</h1>
	<pre>
		<b>YOU ARE APPROVED FOR A LOAN AMOUNT :: <%=new Random().nextInt(10000)%></b>
	</pre>
	<br />

	<a href="./">HOME</a>
	<br />
	<a href="logout">LOGOUT</a>
</body>
</html>