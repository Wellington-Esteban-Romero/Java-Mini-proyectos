package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Producto;
import services.TiendaService;


@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String producto = request.getParameter("producto");

		String seccion = request.getParameter("seccion");

		double precio = Double.parseDouble(request.getParameter("precio"));

		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto p = new Producto(producto, seccion, precio, stock);
		
		TiendaService.addProducto(p);
		
		request.getRequestDispatcher("TiendaServlet?accion=alta").forward(request, response);


	}

}
