package ejemplo.saludos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaludosServlet")
public class SaludosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaludosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Saludos</title>");
		out.print("</head>");
		out.print("<body>");
		for (int i = 1; i <=6; i++) {
			out.print("<h"+i+">Hola Mundo</h"+i+"><br/>");	
		}
		out.print("<body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
