package com.arquitecturajava.servicios;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.ComentarioRepository;
import com.arquitecturajava.repositorios.NoticiaRepository;

public interface ServicioNoticia {

	Noticia findOneNoticia(String id);

	Iterable<Noticia> findAllNoticias();

	void saveNoticia(Noticia object);

	void deleteNoticia(Noticia object);

	Comentario findOneComentario(Integer id);

	Iterable<Comentario> findAllComentarios();

	void saveComentario(Comentario object);

	void deleteComentario(Comentario object);
	
	NoticiaRepository getNoticiaRepository();
	
	void setNoticiaRepository(NoticiaRepository noticiaRepository);
	
	ComentarioRepository getComentarioRepository();
	
	void setComentarioRepository(ComentarioRepository comentarioRepository);

}