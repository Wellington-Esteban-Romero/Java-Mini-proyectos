<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fomulario de validación</title>
</head>
<body align="center">

<p>fecha �ltima visita:${cookie.fecha.value}</p>

<form action="LoginServlet" method="post">
	<div>
		<label for="usuario">usuario:</label>
		<input type="text" name="usuario"/>
	</div>
	<br/>
	
	<div>
		<label for="contra">Contrase�a: </label>
		<input type="password" name="contra"/>
	</div>
	<br/>
	
	<input type="submit" name="login" value="login">

</form>

</body>
</html>