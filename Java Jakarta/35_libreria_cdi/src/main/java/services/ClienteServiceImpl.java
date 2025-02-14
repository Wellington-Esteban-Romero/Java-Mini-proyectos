package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locator.ConnectionLocator;
import models.Cliente;

@Named(value = "clienteServiceImpl")
@RequestScoped
public class ClienteServiceImpl implements ClienteService {
	
	private static final String SELECT_USUARIO = "select * from clientes where usuario=? and password=?";
	private static final String INSERT_USUARIO = "insert into clientes (idCliente,usuario,password,email,telefono) values(?,?,?,?,?)";

	@Override
	public boolean findClienteByUsuarioAndPassword (String usuario, String contrasenia) {

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

	@Override
	public void insertCliente (Cliente cliente) {

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
