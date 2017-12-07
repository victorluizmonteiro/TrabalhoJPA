package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	protected EntityManager em;
	
	private Class<T> clazz;
		
		@SuppressWarnings("all")
		public GenericDAOImpl(EntityManager em) {		
			this.em = em;
			clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
								.getActualTypeArguments()[0];
		}
	@Override
	public void insert(T entity) {
		
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
		
	}

	@Override
	public void update(T entity) {
		
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();

			
	}

	@Override
	public void remove(K id) {
		T entidade = findById(id);
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return em.createQuery("from " + clazz.getSimpleName()).getResultList();
	}

	@Override
	public T findById(K id) {
		return em.find(clazz, id);
	}

}
