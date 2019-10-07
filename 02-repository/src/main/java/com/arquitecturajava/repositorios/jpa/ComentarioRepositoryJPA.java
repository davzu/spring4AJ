package com.arquitecturajava.repositorios.jpa;

import javax.persistence.EntityManager;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.repositorios.ComentarioRepository;

public class ComentarioRepositoryJPA implements ComentarioRepository {
	
	EntityManager entityManager;

	@Override
	public Comentario findOne(int id) {
		return entityManager.find(Comentario.class, id);
	}

	@Override
	public Iterable<Comentario> findAll() {
		return entityManager.createQuery("select c from Comentario c", Comentario.class).getResultList();
	}

	@Override
	public void save(Comentario comentario) {
		entityManager.persist(comentario);
	}

	@Override
	public void delete(Comentario comentario) {
		entityManager.remove(comentario);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
