package br.com.paintball.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.paintball.model.entity.User;

@Component
public class ClientDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(User obj) {
		entityManager.persist(obj);		
	}

	public void update(User obj) {
		entityManager.merge(obj);		
	}
	
	public User findById(Long id) {
		return (User) entityManager.find(User.class, id);
    }

	public List<User> list() {
		return entityManager.createQuery(("FROM " + User.class.getName())).getResultList();
    }

	public void remove(User obj) {
		entityManager.remove(obj);
	}	
	
}
