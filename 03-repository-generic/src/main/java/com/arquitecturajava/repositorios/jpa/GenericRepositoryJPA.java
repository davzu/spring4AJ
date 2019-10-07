package com.arquitecturajava.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.arquitecturajava.repositorios.GenericRepository;

public class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {
	
	private EntityManager entityManager;
	private Class<T> type;

	public GenericRepositoryJPA(Class<T> type) {
		this.type = type;
	}

	@Override
	public T findOne(K id) {
		return entityManager.find(type, id);
	}

	@Override
	public Iterable<T> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
		Root<T> root = criteriaQuery.from(type);
		criteriaQuery.select(root);
		
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void save(T object) {
		entityManager.persist(object);
	}

	@Override
	public void delete(T object) {
		entityManager.remove(object);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
