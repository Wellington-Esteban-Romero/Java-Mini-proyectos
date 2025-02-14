package models;

public class Perfil {

	private String usuario;
	
	private String contrasenia;

	private String email;
	
	private int edad;

	public Perfil() {}

	public Perfil(String usuario, String contrasenia,  String email, int edad) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.edad = edad;
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
