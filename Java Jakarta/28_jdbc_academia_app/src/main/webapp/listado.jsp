<%@page import="models.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos</title>
</head>
<body align="center">

<% List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos"); %>

<br/><br/>

<table align="center" border="1">
	
	<% if (alumnos.size() == 0) {%>
		<h2>No hay Alumnos</h2>
	<% } else { %>
		<tr><th>Nombre</th><th>Curso</th><th>precio</th></tr>
		<% for (int i=0; i<alumnos.size(); i++) {%>
		<tr>
			<td><%=alumnos.get(i).getNombre()%></td>
			<td><%=alumnos.get(i).getCurso()%></td>
			<td><%=alumnos.get(i).getNota()%></td>
<%-- 			<td><a href="EliminarServlet?id=<%=i%>">Eliminar</a></td> --%>
		</tr>
		<% } %>
	<% } %>

</table>

<a href="inicio.html">Volver</a>

</body>
</html>