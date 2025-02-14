package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import models.Perfil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	List<Perfil> perfiles=List.of(new Perfil("admin","admin","admin@gmail.com",45),
			new Perfil("user","user","user@gmail.com",67),
			new Perfil("operator","operator","oper@gmail.com",31),
			new Perfil("main","main","main@gmail.com",41));



	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");

		String contrasenia = request.getParameter("contra");

		for (Perfil perfil : perfiles) {
			if (usuario.equals(perfil.getUsuario()) && contrasenia.equals(perfil.getContrasenia())) {
				request.setAttribute("fecha", new Date());
				request.setAttribute("usuario", perfil);
				request.getRequestDispatcher("EntradaServlet").forward(request, response);
			} 
		}

		request.getRequestDispatcher("ErrorServlet").forward(request, response);

	}

}
