package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TablaServlet")
public class TablaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TablaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Tabla Multiplicar</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Tabla 10 * 10<h1>");
		out.print("<table border='1'>");
		for (int i = 1; i <=10; i++) {
			out.print("<tr>");
			for (int j = 1; j <=10; j++) {
					out.print("<td>"+ (i*j) +"</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
