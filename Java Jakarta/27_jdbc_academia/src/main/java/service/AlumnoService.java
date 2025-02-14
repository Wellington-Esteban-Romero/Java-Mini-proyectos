package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Alumno;

public class AlumnoService {

	private AlumnoService() {

	}

	public static final String URL = "jdbc:mysql://localhost:3306/academia";

	public static final String USUARIO = "root";

	public static final String CONTRA = "";

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	static{
		try {
			Class.forName(DRIVER);
			getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static List<Alumno> getAllAlumno () {
//
//		List<Alumno> alumnos = new ArrayList<>();
//
//		try(
//				Connection conn = getConnection ();
//				Statement st = conn.createStatement()
//				) {
//			String query = "select * from alumnos";
//			ResultSet rs = st.executeQuery(query);
//
//			while (rs.next()) {
//
//				Alumno alumno = new Alumno(rs.getString("nombre"),rs.getString("curso"), rs.getDouble("nota"));
//
//				alumnos.add(alumno);
//			}
//
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return alumnos;
//	}

	public static void insertAlumno (Alumno alumno) {

		try(
				Connection conn = getConnection ();
				Statement st = conn.createStatement()
				) {
			String query = "insert into alumnos (nombre,curso,nota) values (0,'"+alumno.getNombre()+"',"+alumno.getCurso()+"',"+alumno.getNota()+"')";
			st.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static Connection getConnection () throws SQLException, ClassNotFoundException {
		return DriverManager.getConnection(URL,USUARIO,CONTRA);
	}

}
