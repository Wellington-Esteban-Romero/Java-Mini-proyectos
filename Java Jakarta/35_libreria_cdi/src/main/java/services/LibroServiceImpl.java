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
import models.Libro;

@Named(value = "libroServiceImpl")
@RequestScoped
public class LibroServiceImpl implements LibroService {
	
	private static final String SELECT_All_LIBROS = "select * from libros where idTema=?";

	@Override
	public List<Libro> findAllLibrosByTema (int idTema) {
		List<Libro> libros = new ArrayList<>();

		try (Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_All_LIBROS);
			ps.setInt(1,idTema);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Libro libro = new Libro(
						rs.getInt("isbn"), 
						rs.getString("titulo"), 
						rs.getString("autor"), 
						rs.getDouble("precio"), 
						rs.getInt("paginas"), 
						rs.getInt("idTema")
						);
				libros.add(libro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;

	}

}
