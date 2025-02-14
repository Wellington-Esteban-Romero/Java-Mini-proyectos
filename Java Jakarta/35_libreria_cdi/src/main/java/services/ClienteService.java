package services;

import models.Cliente;

public interface ClienteService {
	
	boolean findClienteByUsuarioAndPassword(String usuario, String contrasenia);
	
	void insertCliente(Cliente cliente);

}
