package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

		Pagina[] paginas = service.getPaginas(tematica);
		
		request.setAttribute("paginas",  paginas);
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		

	}

}
