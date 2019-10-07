package com.arquitecturajava.repositorios.jpa;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.NoticiaRepository;

public class NoticiaRepositoryJPA extends GenericRepositoryJPA<Noticia, String> implements NoticiaRepository {
	
	public NoticiaRepositoryJPA() {
		super(Noticia.class);
	}
	

}
