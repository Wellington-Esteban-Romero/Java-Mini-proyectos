package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pagina;

@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	List<Pagina> paginas=List.of(new Pagina("https://www.fnac.es","libros","Libros y más cosas"),
			new Pagina("https://www.gamer.es","juegos","Juegos on-line"),
			new Pagina("https://www.casadellibro.es","libros","La Web de los libros"),
			new Pagina("https://www.mydisc.es","musica","Música de todo tipo"),
			new Pagina("https://www.radio.es","musica","Música de actualidad"));


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tematica = request.getParameter("tematica");

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Resultados</title>");
		out.print("</head>");
		out.print("<body>");

		if (tematica==null || tematica.isEmpty()) {
			out.print("<h2>No existe temática</h2>");
		} else {

			for (Pagina pagina : paginas) {
				if (pagina.getTematica().equals(tematica.trim())) {
					out.print("<span>Dirección: <a href='"+  pagina.getDireccion() +"'>"+ pagina.getDireccion() +"</a></span><br>");
					out.print("<span>Temática: "+ pagina.getTematica() +"</span><br>");
					out.print("<span>Descripción: "+ pagina.getDescripcion() +"</span>");
					out.print("<hr/>");
				}
			}
		}

		out.print("<body>");
		out.print("</html>");
	}

}
