package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Producto;

/**
 * Servlet implementation class EliminarServlet
 */
@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Producto> productos = (List<Producto>) session.getAttribute("productos");

		String id = request.getParameter("id");

		if (productos != null) {
			productos.remove(Integer.parseInt(id));
		}
		
		request.getRequestDispatcher("verCompras.jsp").forward(request, response);
	}

}
