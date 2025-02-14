package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pagina;
import service.BuscadorService;

@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		BuscadorService service = new BuscadorService();

		String tematica = request.getParameter("tematica");

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Resultados</title>");
		out.print("</head>");
		out.print("<body>");

		Pagina[] paginas = service.getPaginas(tematica);
		if (paginas.length == 0) {
			out.print("<h2>No existe temática</h2>");
		} else {
			for (Pagina pagina : paginas) {
				out.print("<span>Dirección: <a href='"+  pagina.getDireccion() +"'>"+ pagina.getDireccion() +"</a></span><br>");
				out.print("<span>Temática: "+ pagina.getTematica() +"</span><br>");
				out.print("<span>Descripción: "+ pagina.getDescripcion() +"</span>");
				out.print("<hr/>");
			}
		}


		out.print("<body>");
		out.print("</html>");
	}

}
