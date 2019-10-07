package com.arquitecturajava.repositorios.jpa;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.repositorios.ComentarioRepository;

public class ComentarioRepositoryJPA extends GenericRepositoryJPA<Comentario, Integer> implements ComentarioRepository {

	public ComentarioRepositoryJPA() {
		super(Comentario.class);
	}
	

}
