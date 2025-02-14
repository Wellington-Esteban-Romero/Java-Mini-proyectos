<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<%
String codigo = request.getParameter("codigo");
String unidades = request.getParameter("unidades");
%>

<h2>Has comprado <%= unidades %> unidades del producto <%=codigo%><h2>

</body>
</html>