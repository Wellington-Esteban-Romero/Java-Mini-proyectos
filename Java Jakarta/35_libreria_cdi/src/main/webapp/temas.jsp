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
<div class="container">
	<form action="FromController?option=doTemas" method="post">
		<div class="form-group">
			<label for="tema">Elegir Tema: </label>
			<select class="form-control" name="idtema">
				<option value="">Seleccione Tema</option>
				<c:forEach var="tema" items="${requestScope.temas}">
					<option value="${tema.idTema}">${tema.tema}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">ver Tema</button>
	</form>
</div>	
</body>
</html>