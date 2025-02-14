package models;

public class Producto {
	
	private String producto;
	
	private String seccion;
	
	private double precio;
	
	private int stock;
	
	public Producto() {}

	public Producto(String producto, String seccion, double precio, int stock) {
		super();
		this.producto = producto;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
