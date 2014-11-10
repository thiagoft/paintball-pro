package br.com.paintball.model.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.dao.ClientDao;
import br.com.paintball.model.entity.Coordinate;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

@Component
public class ClientBusiness {
	private ClientDao clientDao;
	private HostBusiness hostBusiness;

	@Autowired
	public ClientBusiness(ClientDao clientDao,HostBusiness hostBusiness) {
		this.clientDao = clientDao;
		this.hostBusiness = hostBusiness;
	}

	public Room updateUser(User user) {
		try {
			user.setLastSend(new Date());
			this.checkUsersStats(user.getRoomKey());
			this.clientDao.update(user); 
			return this.hostBusiness.findRoom(user.getRoomKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean removeUser(User user) {
		try {
			this.clientDao.remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User insertUser(User user) {
		try {
			user.setLastSend(new Date());
			this.clientDao.insert(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void checkUsersStats(Long roomKey) {
		Room room = this.hostBusiness.findRoom(roomKey);
		List<User> users = new ArrayList<User>();
		for (User userToUpdate : room.getUserList()) {
			if (new Date().getTime() - userToUpdate.getLastSend().getTime() > 10000) {
				users.add(userToUpdate);
			}
		}
		
		for (User user : users){
			this.clientDao.update(new User(user.getUserId(),user.getUserName(),
									  new Coordinate(0.0,0.0),user.getUserClass(),
									  user.getRoomKey(),user.getCommands(),user.getLastSend()));
		}
	}
}
