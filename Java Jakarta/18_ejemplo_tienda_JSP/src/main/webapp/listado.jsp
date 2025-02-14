<%@page import="models.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Producto> productos = (List<Producto>) request.getAttribute("listado"); %>

<table border="1">
<tr><th>Producto</th><th>Seccion</th><th>Precio</th><th>Stock</th></tr>

<% for (int i=0; i<productos.size(); i++) {%>
	<tr>
		<td><%=productos.get(i).getProducto()%></td>
		<td><%=productos.get(i).getSeccion()%></td>
		<td><%=productos.get(i).getPrecio()%></td>
		<td><%=productos.get(i).getStock()%></td>
	</tr>

<% } %>

</table>

</body>
</html>