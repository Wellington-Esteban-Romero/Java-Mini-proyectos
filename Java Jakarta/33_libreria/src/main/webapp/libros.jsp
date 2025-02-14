<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Librería</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<br/>
<br/>
<div class="container">
	<c:choose>
		<c:when test="${empty requestScope.libros}">
			<c:set value="No hay libros" />
		</c:when>
		<c:otherwise>
			<p>Lista de temas de : ${requestScope.tema}</p>
			<table class="table table-bordered">
				<thead><tr><th>ISBN</th><th>TITULO</th><th>AUTOR</th><th>PRECIO</th><th>PAGINAS</th></tr></thead>
				<tbody>
					<c:forEach var="libro" items="${requestScope.libros}">
						<tr>
							<td>${libro.isbn}</td>
							<td>${libro.titulo}</td>
							<td>${libro.autor}</td>
							<td>${libro.precio}</td>
							<td>${libro.paginas}</td>
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