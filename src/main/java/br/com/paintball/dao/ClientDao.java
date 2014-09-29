package br.com.paintball.dao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

public class ClientDao {

	private GenericDao genericDao;

	@Autowired
	public ClientDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public Room updateUser(User user) {
		return (Room) this.genericDao.update(User.class.getName(),user);
	}
	
}
