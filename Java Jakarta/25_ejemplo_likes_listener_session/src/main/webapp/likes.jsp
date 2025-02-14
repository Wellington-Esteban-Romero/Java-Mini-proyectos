<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<% Integer likes = (Integer) application.getAttribute("contador");%>

<% Integer usuarios = (Integer) session.getServletContext().getAttribute("usuarios");
if (usuarios < 0) {
	session.invalidate();
} else {
	session.setMaxInactiveInterval(60);
}

%>
	
	<h2>Usuarios: <%=usuarios %></h2>
	
<%if (likes!=0) {%>
	<h1>Total de likes:<%=likes%></h1>
<%} else {%>
	<h2>No hay likes</h2>
<%}%>

<br/><br/>
<a href="index.html">Volver</a>
</body>
</html>