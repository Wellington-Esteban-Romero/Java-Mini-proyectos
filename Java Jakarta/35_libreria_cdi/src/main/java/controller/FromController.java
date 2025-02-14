package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FromController")
public class FromController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String option = request.getParameter("option");

		String url = "/";

		switch (option) {
		case "doIniciarSesion":
			request.getRequestDispatcher("InicioSesionAction").include(request, response);
			url = (boolean)request.getAttribute("validado") == true? "temas.jsp" : "errorAuth.html";
			break;
		case "toRegistro":
			url = "registro.html";
			break;
		case "doRegistro":
			request.getRequestDispatcher("RegistroAction").include(request, response);
			url = (boolean)request.getAttribute("validado") == false? "usuarioDuplicado.html" : "login.html";
			break;
		case "doTemas":
			request.getRequestDispatcher("LibrosAction").include(request, response);
			url = "libros.jsp";
			break;
		case "toLogin":
			url = "login.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
