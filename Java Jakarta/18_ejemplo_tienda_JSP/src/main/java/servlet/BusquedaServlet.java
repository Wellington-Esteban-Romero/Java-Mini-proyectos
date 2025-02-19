package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Producto;
import services.TiendaService;


@WebServlet("/BusquedaServlet")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seccion = request.getParameter("seccion");

		List<Producto> productos = TiendaService.getProductos(seccion);
		
		request.setAttribute("listado", productos);
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

}
