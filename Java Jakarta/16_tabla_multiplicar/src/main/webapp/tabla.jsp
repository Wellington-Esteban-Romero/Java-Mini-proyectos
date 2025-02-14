<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<%int numero = Integer.parseInt(request.getParameter("numero")); %>
<h1>Tabla del <%=numero%></h1>
<table border="1" align="center">
	<%for (int i=1; i<=10; i++){%>
		<tr>
			<td><%=numero+"x"+i%></td>
			<td><%=numero*i%></td>
		</tr>
	<%}%>
</table>
	<a href="datos.html">Volver</a>
</body>
</html>