package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>Busquedas</title>");
		out.print("</head>");
		out.print("<body align=\"center\">");
		out.print("<table border=\"1\">");
		out.print("<thead>Producto</thead>");
		out.print("<thead>Seccion</thead>");
		out.print("<thead>Precio</thead>");
		out.print("<thead>Stock</thead>");

		List<Producto> productos = TiendaService.getProductos(seccion);

		if (productos.size() == 0) {
			out.print("<h1>No hay productos</h1>");
		} else {
			for (int i = 0; i < productos.size(); i++) {
				out.print("<tr>");
				out.print("<td>"+productos.get(i).getProducto()+"</td>");
				out.print("<td>"+productos.get(i).getSeccion()+"</td>");
				out.print("<td>"+productos.get(i).getPrecio()+"</td>");
				out.print("<td>"+productos.get(i).getStock()+"</td>");
				out.print("</tr>");
			}
		}

		out.print("</table>");
		out.print("<body>");
		out.print("</html>");
	}

}
