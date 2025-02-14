package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TiendaServlet")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("busqueda")) {
			request.getRequestDispatcher("buscar.html").forward(request, response);
		} else if (accion.equals("alta")) {
			request.getRequestDispatcher("alta.html").forward(request, response);
		} else {
			request.getRequestDispatcher("eliminar.html").forward(request, response);
		}
		
	}

}
