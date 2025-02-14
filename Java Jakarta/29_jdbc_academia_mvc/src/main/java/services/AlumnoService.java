package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Alumno;

public class AlumnoService {

	private AlumnoService() {}

	public static final String URL = "jdbc:mysql://localhost:3306/academia";

	public static final String USUARIO = "root";

	public static final String CONTRA = "";

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	static{
		try {
			Class.forName(DRIVER);
			getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


	public static List<Alumno> findAllAlumnoByCurso (String curso) {

		List<Alumno> alumnos = new ArrayList<>();

		try(
				Connection conn = getConnection ();
				Statement st = conn.createStatement()
				) {
			String query = "select * from alumnos";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString("curso").equals(curso)) {
					Alumno alumno = new Alumno(rs.getInt("idAlumno"),rs.getString("nombre"),rs.getString("curso"), rs.getDouble("nota"));
					alumnos.add(alumno);
				}
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	public static List<String> findAllCurso () {

		List<String> cursos = new ArrayList<>();

		try(Connection conn = getConnection ()) {
			String query = "select distinct curso from alumnos";
			PreparedStatement ps =  conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cursos.add(rs.getString("curso"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	public static Alumno findAlumnoByDNI (String dni) {

		Alumno alumno = null;

		try(Connection conn = getConnection ();) {

			String query = "select * from alumnos where idalumno=?";
			PreparedStatement ps =  conn.prepareStatement(query);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				alumno = new Alumno(rs.getInt("idAlumno"),rs.getString("nombre"),rs.getString("curso"), rs.getDouble("nota"));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumno;
	}

	public static void insertAlumno (Alumno alumno) {

		try(Connection conn = getConnection ()) {
			PreparedStatement ps = conn.prepareStatement("insert into alumnos (nombre,curso,nota) values (?,?,?)");
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getCurso());
			ps.setDouble(3, alumno.getNota());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteAlumno (String curso) {

		try(Connection conn = getConnection ()) {
			PreparedStatement ps = conn.prepareStatement("delete from alumnos where curso=?");
			ps.setString(1, curso);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection () throws SQLException {
		return DriverManager.getConnection(URL,USUARIO,CONTRA);
	}

}
