package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alumno;
import services.AlumnoService;

@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		String curso = request.getParameter("curso");

		double nota = Double.parseDouble(request.getParameter("nota"));

		AlumnoService.insertAlumno(new Alumno(0,nombre,curso,nota));

	}
}
