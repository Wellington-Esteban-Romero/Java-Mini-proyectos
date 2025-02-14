package service;

import java.util.List;

import models.Perfil;

public class ValidacionService {

	List<Perfil> perfiles=List.of(new Perfil("admin","admin","admin@gmail.com",45),
			new Perfil("user","user","user@gmail.com",67),
			new Perfil("operator","operator","oper@gmail.com",31),
			new Perfil("main","main","main@gmail.com",41));
	
	public Perfil getPerfil (String usuario, String contrasenia) {
		
		for (Perfil perfil : perfiles) {
			if (usuario.equals(perfil.getUsuario()) && contrasenia.equals(perfil.getContrasenia())) {
				return perfil;
			} 
		}
		
		return null;
	}

}
