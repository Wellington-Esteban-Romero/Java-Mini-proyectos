package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locator.ConnectionLocator;
import models.Tema;

@Named(value = "temaServiceImpl")
@RequestScoped
public class TemaServiceImpl implements TemaService {
	
	private static final String SELECT_All_TEMAS = "select * from temas";
	private static final String SELECT_TEMA = "select * from temas where idtema=?";

	@Override
	public List<Tema> findAllTema () {

		List<Tema> temas = new ArrayList<>();

		try (Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_All_TEMAS);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Tema tema = new Tema(
						Integer.parseInt(rs.getString("idTema")),
						rs.getString("Tema")
						);
				temas.add(tema);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temas;
	}

	@Override
	public String findTemaById (int idTema) {

		Tema tema = null;

		try (Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_TEMA);
			ps.setInt(1, idTema);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				tema = new Tema(
						Integer.parseInt(rs.getString("idTema")),
						rs.getString("Tema")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tema.getTema();
	}

}
