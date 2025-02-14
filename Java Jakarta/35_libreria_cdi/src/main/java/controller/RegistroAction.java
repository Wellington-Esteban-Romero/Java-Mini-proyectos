package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cliente;
import services.ClienteService;

@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ClienteService clienteService;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = new Cliente(0, request.getParameter("usuario"), request.getParameter("password"), request.getParameter("email"),Integer.parseInt(request.getParameter("telefono")));

		if (clienteService.findClienteByUsuarioAndPassword(cliente.getUsuario(), cliente.getPassword()))
			request.setAttribute("validado", false);
		else {
			clienteService.insertCliente(cliente);
			request.setAttribute("validado", true);
		}
	}

}
