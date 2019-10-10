package com.arquitecturajava.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.repositorios.ComentarioRepository;

@Repository
public class ComentarioRepositoryJPA extends GenericRepositoryJPA<Comentario, Integer> implements ComentarioRepository {

	public ComentarioRepositoryJPA() {
		super(Comentario.class);
	}
	

}
