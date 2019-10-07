package com.arquitecturajava.servicios.jpa;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.ComentarioRepository;
import com.arquitecturajava.repositorios.NoticiaRepository;
import com.arquitecturajava.servicios.ServicioNoticia;

public class ServicioNoticiaJPA implements ServicioNoticia {

	private NoticiaRepository noticiaRepository;
	private ComentarioRepository comentarioRepository;	
	
	@Override
	public Noticia findOneNoticia(String id) {
		return noticiaRepository.findOne(id);
	}
	
	@Override
	public Iterable<Noticia> findAllNoticias() {
		return noticiaRepository.findAll();
	}
	
	@Override
	public void saveNoticia(Noticia object) {
		noticiaRepository.save(object);
	}
	
	@Override
	public void deleteNoticia(Noticia object) {
		noticiaRepository.delete(object);
	}
	
	@Override
	public Comentario findOneComentario(Integer id) {
		return comentarioRepository.findOne(id);
	}
	
	@Override
	public Iterable<Comentario> findAllComentarios() {
		return comentarioRepository.findAll();
	}
	
	@Override
	public void saveComentario(Comentario object) {
		comentarioRepository.save(object);
	}
	
	@Override
	public void deleteComentario(Comentario object) {
		comentarioRepository.delete(object);
	}
	public NoticiaRepository getNoticiaRepository() {
		return noticiaRepository;
	}
	public void setNoticiaRepository(NoticiaRepository noticiaRepository) {
		this.noticiaRepository = noticiaRepository;
	}
	public ComentarioRepository getComentarioRepository() {
		return comentarioRepository;
	}
	public void setComentarioRepository(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}

	
}
