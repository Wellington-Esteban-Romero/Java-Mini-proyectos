<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fomulario de validaciÃ³n</title>
</head>
<body align="center">

<%
Cookie[] ck = request.getCookies();

if (ck != null) {
	for (Cookie c : ck) {
		if (c.getName().equals("fecha")) {%>
			<h2>Fecha de la última entrada: <%=c.getValue()%></h2>
		<%}%>
		<%}%>
	<%}%>




<form action="LoginServlet" method="post">
	<div>
		<label for="usuario">usuario:</label>
		<input type="text" name="usuario"/>
	</div>
	<br/>
	
	<div>
		<label for="contra">Contraseña: </label>
		<input type="password" name="contra"/>
	</div>
	<br/>
	
	<input type="submit" name="login" value="login">

</form>

</body>
</html>