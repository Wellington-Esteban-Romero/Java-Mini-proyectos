package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usuario = request.getParameter("usuario");

		String contrasenia = request.getParameter("contra");

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Bienvenido</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>El usuario "+ usuario + " o la constraseña " + contrasenia + " no es correcta" +"<h2>");
		out.print("<body>");
		out.print("</html>");
	}

}
