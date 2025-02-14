package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
	private int idAlumno;
	private String nombre;
	private String curso;
	private double nota;
}
