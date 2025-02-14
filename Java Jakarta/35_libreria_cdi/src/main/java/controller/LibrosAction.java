package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LibroService;
import services.TemaService;

@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	TemaService temaService;

	@Inject
	LibroService libroService;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", libroService.findAllLibrosByTema(Integer.parseInt(request.getParameter("idtema"))));
		request.setAttribute("tema", temaService.findTemaById(Integer.parseInt(request.getParameter("idtema"))));
	}
}
