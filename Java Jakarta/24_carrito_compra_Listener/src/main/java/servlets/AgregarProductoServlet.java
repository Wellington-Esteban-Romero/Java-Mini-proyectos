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

@WebServlet("/AgregarProductoServlet")
public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		String precio = request.getParameter("precio");

		String seccion = request.getParameter("seccion");

		HttpSession session = request.getSession();

		List<Producto> productos = (List<Producto>) session.getAttribute("productos");

		productos.add(new Producto(nombre, precio, seccion));
		session.setAttribute("productos", productos);

		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
