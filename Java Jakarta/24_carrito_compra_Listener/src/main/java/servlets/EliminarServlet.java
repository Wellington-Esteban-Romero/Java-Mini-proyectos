package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Producto;

@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Producto> productos = (List<Producto>) request.getSession().getAttribute("productos");

		String id = request.getParameter("id");

		if (productos.size() > 0) {
			productos.remove(Integer.parseInt(id));
		}
		request.getRequestDispatcher("verCompras.jsp").forward(request, response);
	}

}
