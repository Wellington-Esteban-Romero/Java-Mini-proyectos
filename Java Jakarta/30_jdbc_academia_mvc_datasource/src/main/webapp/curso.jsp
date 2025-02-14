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
<body>
<br/>
<br/>
<% List<String> cursos = (List<String>) request.getAttribute("cursos"); %>
<div class="container">
	<form action="FromController?option=doCursos" method="post">
		<div class="form-group">
			<label for="curso">Elegir curso: </label>
			<select class="form-control" name="curso">
				<option value="">Seleccione Curso</option>
				<% for (int i=0; i<cursos.size(); i++) {%>
					<option value="<%=cursos.get(i)%>"><%=cursos.get(i).toUpperCase()%></option>
				<%}%>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">verAlumnos</button>
	</form>
</div>
</body>
</html>