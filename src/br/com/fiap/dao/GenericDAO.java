package br.com.fiap.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	
	void insert(T entity);
	void update(T entity);
	void remove(K id);
	List<T>list();
	T findById(K id);
	
	
	
	

}