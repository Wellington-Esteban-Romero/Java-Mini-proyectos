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
		case "toAlta":
			url = "alta.html";
			break;
		case "toBaja":
			url = "baja.html";
			break;
		case "toCurso":
			request.getRequestDispatcher("CursosAction").include(request, response);
			url = "curso.jsp";
			break;
		case "doCursos":
			request.getRequestDispatcher("AlumnosAction").include(request, response);
			url = "listado.jsp";
			break;
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			url = "inicio.html";
			break;
		case "doBaja":
			request.getRequestDispatcher("BajaAction").include(request, response);
			url = "inicio.html";
			break;
		case "toAlumno":
			url = "buscar.html";
			break;
		case "doAlumno":
			request.getRequestDispatcher("BuscarAction").include(request, response);
			url = "alumno.jsp";
			break;
		case "toVolver":
			url = "inicio.html";
			break;

		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
