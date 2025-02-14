<%@page import="models.Perfil"%>
<%@page import="models.Pagina"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Perfil p = (Perfil) session.getAttribute("usuario");%>

<h2>Bienvenido: <%=p.getUsuario()%></h2>

<br/>

<a href="DesconexionServlet">Desconexión</a>

<br/>
<br/>

<% Pagina[] paginas = (Pagina[]) request.getAttribute("paginas"); %>

<% for (int i=0; i< paginas.length; i++) {%>
	<span>Dirección: <a href=<%=paginas[i].getDireccion()%>><%=paginas[i].getDireccion()%></a></span><br>
	<span>Temática: <%=paginas[i].getTematica()%> </span><br>
	<span>Descripción: <%=paginas[i].getDescripcion()%></span><br>
	<hr/>
<%}%>

<hr/>

</body>
</html>