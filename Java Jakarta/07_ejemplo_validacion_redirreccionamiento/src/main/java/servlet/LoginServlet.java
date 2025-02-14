package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");

		String contrasenia = request.getParameter("contra");

		if ("admin".equals(usuario) && "admin".equals(contrasenia)) {
//			request.getRequestDispatcher("EntradaServlet").forward(request, response);
			response.sendRedirect("EntradaServlet");
		} else {
//			request.getRequestDispatcher("ErrorServlet").forward(request, response);
			response.sendRedirect("ErrorServlet");
		}

	}

}
