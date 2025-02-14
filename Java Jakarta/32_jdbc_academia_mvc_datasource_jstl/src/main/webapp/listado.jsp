<%@page import="models.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="container">
	<c:choose>
		<c:when test="${empty requestScope.alumnos}">
			<c:set value="No hay alumno" />
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<thead><tr><th>Nombre</th><th>Curso</th><th>precio</th></tr></thead>
				<tbody>
					<c:forEach var="alumno" items="${requestScope.alumnos}">
						<tr>
							<td>${alumno.nombre}</td>
							<td>${alumno.curso}</td>
							<td>${alumno.nota}</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="FromController?option=toVolver">Volver</a>
</div>
</body>
</html>