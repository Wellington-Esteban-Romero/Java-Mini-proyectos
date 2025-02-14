package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.TiendaService;

@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String seccion = request.getParameter("seccion");
//		
//		TiendaService.deleteProducto(null);
		
		
	}

}
