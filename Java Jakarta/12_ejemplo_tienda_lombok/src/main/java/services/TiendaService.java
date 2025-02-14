package services;

import java.util.ArrayList;
import java.util.List;

import models.Producto;

public class TiendaService {
	
	private TiendaService() {}

	static ArrayList<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentaci�n",8.4,25),
			new Producto("leche","alimentaci�n",1.2,70),
			new Producto("cable usb","inform�tica",5.6,30),
			new Producto("arroz","alimentaci�n",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","inform�tica",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));

	public static List<Producto> getProductos (String seccion) {

		List<Producto> lista = new ArrayList<>();

		for (Producto producto : productos) {
			if (seccion.equals(producto.getSeccion())) {
				lista.add(producto);
			}
		}

		return lista;
	}

	public static void addProducto (Producto p) {
		aumentarStock(p);
		if (!isExisteProducto(p))
			productos.add(p);
	}

	public static void deleteProducto (Producto p) {
		for (int i = 0; i < productos.size(); i++) {
			if (p.getProducto().equals(productos.get(i).getProducto()) && p.getSeccion().equals(productos.get(i).getSeccion())) {
				productos.remove(i);
				break;
			}
		}
	}

	private static void aumentarStock (Producto p) {
		for (int i = 0; i < productos.size(); i++) {
			if (p.getProducto().equals(productos.get(i).getProducto()) && p.getSeccion().equals(productos.get(i).getSeccion())) {
				int stock = productos.get(i).getStock() + p.getStock();
				productos.get(i).setStock(stock);
				break;
			}
		}
	}

	private static boolean isExisteProducto (Producto p) {
		for (int i = 0; i < productos.size(); i++) {
			if (p.getProducto().equals(productos.get(i).getProducto()) && p.getSeccion().equals(productos.get(i).getSeccion())) {
				return true;
			}
		}
		return false;
	}

}
