package com.arquitecturajava.repositorios;

import com.arquitecturajava.bo.Noticia;

public interface NoticiaRepository {

	public Noticia findOne(String titulo);

	public Iterable<Noticia> findAll();

	public void save(Noticia noticia);

	public void delete(Noticia noticia);

}
