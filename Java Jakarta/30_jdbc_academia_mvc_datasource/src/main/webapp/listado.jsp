<%@page import="models.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>App Academia</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body align="center">
<br/>
<br/>
<% List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos"); %>
<div class="container">
	<% if (alumnos.size() > 0) {%>
		<h2>Alumnos</h2>
	<%} %>
	<div class="table-responsive">
	    <table class="table table-bordered">
			
			<% if (alumnos.size() == 0) {%>
				<h2>No hay Alumnos</h2>
			<% } else { %>
				<thead><tr><th>Nombre</th><th>Curso</th><th>precio</th></tr></thead>
				<tbody>
				<% for (int i=0; i<alumnos.size(); i++) {%>
				<tr>
					<td><%=alumnos.get(i).getNombre()%></td>
					<td><%=alumnos.get(i).getCurso()%></td>
					<td><%=alumnos.get(i).getNota()%></td>
				</tr>
				<% } %>
				</tbody>
			<% } %>
		
		</table>
	</div>
	<a href="FromController?option=toVolver">Volver</a>
</div>
</body>
</html>