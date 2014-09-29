package br.com.paintball.model.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.dao.ClientDao;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

@Component
public class ClientBusiness {
	private ClientDao clientDao;

	@Autowired
	public ClientBusiness(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public Room addUser(User user) {
		try {
			return this.clientDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
