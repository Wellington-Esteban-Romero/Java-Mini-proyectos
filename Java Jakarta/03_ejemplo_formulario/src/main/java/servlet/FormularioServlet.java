package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
    public FormularioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		
		String unidades = request.getParameter("unidades");
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Saludos</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>Has comprado " + unidades +" unidades del producto"+ codigo +"<h2>");
		out.print("<body>");
		out.print("</html>");
	}

}
