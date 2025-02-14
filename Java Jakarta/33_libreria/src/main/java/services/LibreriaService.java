package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locator.ConnectionLocator;
import models.Cliente;
import models.Libro;
import models.Tema;

public class LibreriaService {

	private static final String SELECT_USUARIO = "select * from clientes where usuario=? and password=?";
	private static final String INSERT_USUARIO = "insert into clientes (idCliente,usuario,password,email,telefono) values(?,?,?,?,?)";
	private static final String SELECT_All_TEMAS = "select * from temas";
	private static final String SELECT_All_LIBROS = "select * from libros where idTema=?";
	private static final String SELECT_TEMA = "select * from temas where idtema=?";

	private LibreriaService() {}

	public static boolean findClienteByUsuarioAndPassword (String usuario, String contrasenia) {

		try (Connection conn = ConnectionLocator.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_USUARIO);

			ps.setString(1, usuario);
			ps.setString(2, contrasenia);

			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Tema> findAllTema () {

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

	public static String findTemaById (int idTema) {

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

	public static List<Libro> findAllLibrosByTema (int idTema) {
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

	public static void insertCliente (Cliente cliente) {

		try (Connection conn = ConnectionLocator.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(INSERT_USUARIO);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getUsuario());
			ps.setString(3, cliente.getPassword());
			ps.setString(4, cliente.getEmail());
			ps.setInt(5, cliente.getTelefono());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
