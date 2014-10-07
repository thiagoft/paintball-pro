package br.com.paintball.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

@Component
public class ClientDao {

	private GenericDao genericDao;

	@Autowired
	public ClientDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public Room updateUser(User user) {
		return (Room) this.genericDao.update(User.class.getName(),user);
	}
	
	public User insertUser(User user) {
		return (User) this.genericDao.insert(User.class.getName(),user);
	}
	
	public boolean removeUser(User user) {
		return this.genericDao.remove(User.class.getName(),user);
	}
	
}
