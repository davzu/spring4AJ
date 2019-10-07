package com.arquitecturajava.repositorios;

public interface GenericRepository<T, K> {
	
	public T findOne(K id);

	public Iterable<T> findAll();

	public void save(T object);

	public void delete(T object);

}
