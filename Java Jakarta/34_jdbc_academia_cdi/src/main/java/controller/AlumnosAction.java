package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AlumnosService;

@WebServlet("/AlumnosAction")
public class AlumnosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	AlumnosService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("alumnos", service.findAllAlumnoByCurso(request.getParameter("curso")));
	}
}
