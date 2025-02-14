<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String usuario = request.getParameter("usuario");

String contrasenia = request.getParameter("contra");
%>

<h2>El usuario <%=usuario%> o la constraseña <%=contrasenia%> no es correcta<h2>

<a href="index.html">Volver</a>

</body>
</html>