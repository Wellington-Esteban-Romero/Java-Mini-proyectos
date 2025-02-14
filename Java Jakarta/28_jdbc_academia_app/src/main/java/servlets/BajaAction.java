package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AlumnoService;


@WebServlet("/BajaAction")
public class BajaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String curso = request.getParameter("curso");

		AlumnoService.deleteAlumno(curso);

		request.getRequestDispatcher("inicio.html").forward(request, response);


	}

}
