package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AlumnoService;


@WebServlet("/AlumnosAction")
public class AlumnosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curso = request.getParameter("curso");
		
		request.setAttribute("alumnos", AlumnoService.findAllAlumnoByCurso(curso));

		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
