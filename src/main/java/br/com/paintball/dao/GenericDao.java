package br.com.paintball.dao;

import br.com.paintball.interfaces.IDao;

//@Repository
//@SuppressWarnings("unchecked")
public abstract class GenericDao<T> implements IDao<T>{
	
	/*@PersistenceContext
	private EntityManager entityManager;

	public void insert(T obj) {
		entityManager.persist(obj);		
	}

	public void update(T obj) {
		entityManager.merge(obj);		
	}
	
	public T findById(Long id) {
		return (T) entityManager.find(getTypeClass(), id);
    }

	public List<T> list() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

	public void remove(T obj) {
		entityManager.remove(obj);
	}	
	
	private Class<?> getTypeClass() {
		Class<?> entity = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return entity;
	}*/

}
