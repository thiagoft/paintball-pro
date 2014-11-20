package br.com.paintball.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.paintball.model.entity.Room;

@Component
public class HostDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Room obj) {
		entityManager.persist(obj);		
	}

	public void update(Room obj) {
		entityManager.merge(obj);		
	}
	
	public Room findById(Long id) {
		return (Room) entityManager.find(Room.class, id);
    }

	public List<Room> list() {
		return entityManager.createQuery(("FROM " + Room.class.getName())).getResultList();
    }

	public void remove(Room obj) {
		entityManager.remove(obj);
	}	
	
}
