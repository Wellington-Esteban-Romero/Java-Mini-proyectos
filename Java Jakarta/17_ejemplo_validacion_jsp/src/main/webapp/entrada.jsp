<%@page import="models.Perfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Perfil perfil = (Perfil) request.getAttribute("usuario"); %>

<h2>Bienvenido <%=perfil.getUsuario()%><h2><br/>
<h2>Email: <%=perfil.getEmail()%><h2><br/>
<h2>Edad: <%=perfil.getEdad()%><h2><br/>

</body>
</html>