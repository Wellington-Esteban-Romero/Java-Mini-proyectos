package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Producto;


@WebServlet("/VerCarritoServlet")
public class VerCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Producto> productos = (List<Producto>) session.getAttribute("productos");

		session.setAttribute("productos", productos);
		request.getRequestDispatcher("verCompras.jsp").forward(request, resp);

	}
}
