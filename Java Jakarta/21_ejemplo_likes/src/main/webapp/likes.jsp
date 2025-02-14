<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<% Integer likes = (Integer) application.getAttribute("contador"); 
	
if (likes!=null) {%>

	<h1>Total de likes:<%=likes%></h1>
<%} else {%>
	<h2>No hay likes</h2>
<%}%>

<br/><br/>
<a href="index.html">Volver</a>
</body>
</html>