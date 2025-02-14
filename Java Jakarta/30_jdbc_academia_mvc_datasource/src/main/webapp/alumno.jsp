<%@page import="models.Alumno"%>
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
<div class="container">
	<% Alumno alumno = (Alumno) request.getAttribute("alumno"); %>
	
	<% if (alumno == null) { %>
		<h2>No existe alumno</h2>
	<% } else { %>
	
	<div class="card bg-light">
      <div class="card-body text-center">
        <p class="card-text">Nombre:&nbsp;&nbsp;<%=alumno.getNombre()%></p>
        <p class="card-text">Curso:&nbsp;&nbsp;<%=alumno.getCurso()%></p>
		<p class="card-text">Nota:&nbsp;&nbsp;<%=alumno.getNota()%></p>
      </div>
	<%}%>
	
	<a href="FromController?option=toVolver">Volver</a>
</div>
</body>
</html>