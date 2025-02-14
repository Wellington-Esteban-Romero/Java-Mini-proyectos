package services;

import java.util.List;

import models.Alumno;

public interface AlumnosService {

	List<Alumno> findAllAlumnoByCurso(String curso);

	List<String> findAllCurso();

	Alumno findAlumnoByDNI(String dni);

	void insertAlumno(Alumno alumno);

	void deleteAlumno(String curso);

}