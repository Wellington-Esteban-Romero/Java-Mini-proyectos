package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ClienteService;
import services.TemaService;

@WebServlet("/InicioSesionAction")
public class InicioSesionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ClienteService clienteService;
	
	@Inject
	TemaService temaService;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (clienteService.findClienteByUsuarioAndPassword(request.getParameter("user"), request.getParameter("pwd"))) {
			request.setAttribute("temas", temaService.findAllTema());
			request.setAttribute("validado", true);
		} else {
			request.setAttribute("validado", false);
		}
	}
}
