package br.com.paintball.dao;

import org.springframework.stereotype.Component;

import br.com.paintball.model.entity.User;

@Component
public class ClientDao extends GenericDao<User> {
	
	/*public Room updateUser(User user) {
		return (Room) this.genericDao.update(User.class.getName(),user);
	}
	
	public User insertUser(User user) {
		return (User) this.genericDao.insert(User.class.getName(),user);
	}
	
	public boolean removeUser(User user) {
		return this.genericDao.remove(User.class.getName(),user);
	}*/
	
}
