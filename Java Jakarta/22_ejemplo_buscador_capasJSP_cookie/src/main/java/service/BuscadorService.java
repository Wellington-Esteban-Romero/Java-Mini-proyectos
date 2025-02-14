package service;

import java.util.Arrays;
import java.util.List;

import models.Pagina;

public class BuscadorService {

	List<Pagina> paginas=List.of(new Pagina("https://www.fnac.es","libros","Libros y más cosas"),
			new Pagina("https://www.gamer.es","juegos","Juegos on-line"),
			new Pagina("https://www.casadellibro.es","libros","La Web de los libros"),
			new Pagina("https://www.mydisc.es","musica","Música de todo tipo"),
			new Pagina("https://www.radio.es","musica","Música de actualidad"));

	public Pagina[] getPaginas (String tematica) {
		
		Pagina[] paginas_aux = new Pagina[0];

		for (Pagina pagina : paginas) {
			if (pagina.getTematica().equals(tematica.trim())) {
				paginas_aux = Arrays.copyOf(paginas_aux, paginas_aux.length+1);
				paginas_aux[paginas_aux.length-1] = pagina;
			}
		}
		return paginas_aux;
	}

}
