package services;

import java.util.List;

import models.Tema;

public interface TemaService {
	
	List<Tema> findAllTema();
	
	String findTemaById(int idTema);

}
