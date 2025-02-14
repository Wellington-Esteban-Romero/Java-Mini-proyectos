<%@page import="java.util.List"%>
<%@page import="models.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<% List<Producto> l = (List<Producto>) session.getAttribute("productos"); %>

<table align="center" boder="1">
	
	<% if (l.size() == 0) {%>
		<h2>No hay productos</h2>
	<% } else { %>
		<tr><th>Nombre</th><th>Precio</th><th>Seccion</th></tr>
		<% for (int i=0; i<l.size(); i++) {%>
		<tr>
			<td><%=l.get(i).getNombre()%></td>
			<td><%=l.get(i).getPrecio()%></td>
			<td><%=l.get(i).getSeccion()%></td>
			<td><a href="EliminarServlet?id=<%=i%>">Eliminar</a></td>
		</tr>
		<% } %>
	<% } %>

<a href="index.html">Volver</a>

</table>

</body>
</html>