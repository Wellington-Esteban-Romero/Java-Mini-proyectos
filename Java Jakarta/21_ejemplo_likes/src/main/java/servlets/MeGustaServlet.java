package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MeGustaServlet")
public class MeGustaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer contador = (Integer) request.getServletContext().getAttribute("contador");

		if (contador == null) {
			contador = 0;
		}
		request.getServletContext().setAttribute("contador", ++contador);
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
