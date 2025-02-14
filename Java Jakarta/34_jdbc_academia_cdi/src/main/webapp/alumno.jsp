<%@page import="models.Alumno"%>
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
<body>
<br/>
<br/>
<div class="container">
	<c:choose>
		<c:when test="${not empty requestScope.alumno}<">
			<h2><c:set value="No existe alumno"/></h2>
		</c:when>
		<c:otherwise>
			<c:set var="alumno" value="${requestScope.alumno}"/>
			<div class="card bg-light">
		      <div class="card-body text-center">
		        <p class="card-text">Nombre:&nbsp;&nbsp;${alumno.nombre}</p>
		        <p class="card-text">Curso:&nbsp;&nbsp;${alumno.curso}</p>
				<p class="card-text">Nota:&nbsp;&nbsp;${alumno.nota}</p>
		      </div>
		    </div>
		</c:otherwise>
	</c:choose>
	<a href="FromController?option=toVolver">Volver</a>
</div>
</body>
</html>