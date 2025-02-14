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
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Búsqueda</title>");
			out.print("</head>");
			out.print("<body align=\"center\">");
			out.print("<form action='BusquedaServlet' method='post'>");
			out.print("Buscar Seccion: <input type='text' name='seccion' />");
			out.print("<input type='submit' name='buscar' value='Buscar'/>");
			out.print("</form>");
			out.print("<body>");
			out.print("</html>");
		} else if (accion.equals("alta")) {
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Alta</title>");
			out.print("</head>");
			out.print("<body align=\"center\">");
			out.print("<form action='AltaServlet' method='post'>");
			out.print("Producto: <input type='text' name='producto' /><br/>");
			out.print("Seccion: <input type='text' name='seccion' /><br/>");
			out.print("precio: <input type='text' name='precio' /><br/>");
			out.print("stock: <input type='text' name='stock' /><br/>");
			out.print("<input type='submit' name='alta' value='Alta'/>");
			out.print("</form>");
			out.print("<body>");
			out.print("</html>");
		} else {
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Eliminar</title>");
			out.print("</head>");
			out.print("<body align=\"center\">");
			out.print("<form action='EliminarServlet' method='post'>");
			out.print("Seccion: <input type='text' name='seccion' />");
			out.print("<input type='submit' name='baja' value='Eliminar'/>");
			out.print("</form>");
			out.print("<body>");
			out.print("</html>");
		}
		
	}

}
