package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Perfil;
import service.ValidacionService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ValidacionService s = new ValidacionService();

		String usuario = request.getParameter("usuario");

		String contrasenia = request.getParameter("contra");

		Perfil p = s.getPerfil(usuario, contrasenia);

		if (p != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", p);
			
			Cookie c = new Cookie("fecha", LocalDateTime.now().toString());
			c.setMaxAge(60);
			response.addCookie(c);
			
			request.getRequestDispatcher("buscador.html").forward(request, response);
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	} 


}
