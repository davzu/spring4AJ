package com.arquitecturajava.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.repositorios.GenericRepository;

@Repository
public abstract class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {
	
	@PersistenceContext
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

	@Transactional
	@Override
	public void save(T object) {
		entityManager.persist(object);
	}

	@Transactional
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
