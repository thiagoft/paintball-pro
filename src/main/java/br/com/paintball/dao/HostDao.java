package br.com.paintball.dao;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.enums.EnumStatus;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

@Component
public class HostDao {
	
	private GenericDao genericDao;

	@Autowired
	public HostDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}	

	public Room createRoom(Long key) {
		Room room = new Room(key, EnumStatus.INATIVO.getStatus(), new HashSet<User>(),null);
		if (this.genericDao.findById(Room.class.getName(), room) == null) {
			if (this.genericDao.save(Room.class.getName(), room)) {
				return (Room) this.genericDao.findById(null, room);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public Room findRoom(Long roomKey) {
		Room room = new Room(roomKey, null, null, null);
		return (Room) this.genericDao.findById(Room.class.getName(), room);
	}
	
	public boolean saveObjectiveCoordinate(Room room) {
		return this.genericDao.save(Room.class.getName(), room);
	}
	
}
