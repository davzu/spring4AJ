package com.arquitecturajava.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.NoticiaRepository;

@Repository
public class NoticiaRepositoryJPA extends GenericRepositoryJPA<Noticia, String> implements NoticiaRepository {
	
	public NoticiaRepositoryJPA() {
		super(Noticia.class);
	}
	

}
