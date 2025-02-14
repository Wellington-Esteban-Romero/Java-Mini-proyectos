package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import models.Perfil;
import service.ValidacionService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		ValidacionService s = new ValidacionService();

		String usuario = request.getParameter("usuario");

		String contrasenia = request.getParameter("contra");

		request.setAttribute("fecha", new Date());

		Perfil p = s.getPerfil(usuario, contrasenia);

		if (p != null) {
			request.setAttribute("usuario", p);
			request.getRequestDispatcher("EntradaServlet").forward(request, response);
		}
		request.getRequestDispatcher("ErrorServlet").forward(request, response);
	} 


}
