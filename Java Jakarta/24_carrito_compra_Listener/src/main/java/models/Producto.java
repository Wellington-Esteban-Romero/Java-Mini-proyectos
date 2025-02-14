package models;

public class Producto {

	private String nombre;

	private String precio;

	private String seccion;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String precio, String seccion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}



}
