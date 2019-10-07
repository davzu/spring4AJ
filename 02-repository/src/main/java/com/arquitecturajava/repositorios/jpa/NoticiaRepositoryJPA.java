package com.arquitecturajava.repositorios.jpa;

import javax.persistence.EntityManager;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.NoticiaRepository;

public class NoticiaRepositoryJPA implements NoticiaRepository {
	
	private EntityManager entityManager;

	@Override
	public Noticia findOne(String titulo) {
		return entityManager.find(Noticia.class, titulo);
	}

	@Override
	public Iterable<Noticia> findAll() {
		return entityManager.createQuery("select n from Noticia n", Noticia.class).getResultList();
	}

	@Override
	public void save(Noticia noticia) {
		entityManager.persist(noticia);
	}

	@Override
	public void delete(Noticia noticia) {
		entityManager.remove(noticia);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
