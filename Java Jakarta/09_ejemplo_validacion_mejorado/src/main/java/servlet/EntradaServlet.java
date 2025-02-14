package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Perfil;

@WebServlet("/EntradaServlet")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Perfil perfil = (Perfil) request.getAttribute("usuario");

		Date fecha = (Date) request.getAttribute("fecha");

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Bienvenido</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>Bienvenido "+ perfil.getUsuario() +"<h2><br/>");
		out.print("<h2>Email:"+ perfil.getEmail() +"<h2><br/>");
		out.print("<h2>Edad: "+ perfil.getEdad() +"<h2><br/>");
		out.print("<h2>Fecha y hora de autentificación: "+ fecha +"<h2>");
		out.print("<body>");
		out.print("</html>");
	}

}
