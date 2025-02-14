package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locator.ConnectionLocator;
import models.Alumno;

@Named(value = "alumnoServiceImpl")
@RequestScoped
public class AlumnosServiceImpl implements AlumnosService {

	private AlumnosServiceImpl() {}

	@Override
	public List<Alumno> findAllAlumnoByCurso (String curso) {

		List<Alumno> alumnos = new ArrayList<>();

		try(
				Connection conn = ConnectionLocator.getConnection ();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public List<String> findAllCurso () {

		List<String> cursos = new ArrayList<>();

		try(Connection conn = ConnectionLocator.getConnection ()) {
			String query = "select distinct curso from alumnos";
			PreparedStatement ps =  conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cursos.add(rs.getString("curso"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public Alumno findAlumnoByDNI (String dni) {

		Alumno alumno = null;

		try(Connection conn = ConnectionLocator.getConnection ()) {

			String query = "select * from alumnos where idalumno=?";
			PreparedStatement ps =  conn.prepareStatement(query);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				alumno = new Alumno(rs.getInt("idAlumno"),rs.getString("nombre"),rs.getString("curso"), rs.getDouble("nota"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumno;
	}

	@Override
	public void insertAlumno (Alumno alumno) {

		try(Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into alumnos (nombre,curso,nota) values (?,?,?)");
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getCurso());
			ps.setDouble(3, alumno.getNota());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAlumno (String curso) {

		try(Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from alumnos where curso=?");
			ps.setString(1, curso);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
