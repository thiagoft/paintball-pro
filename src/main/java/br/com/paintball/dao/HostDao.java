package br.com.paintball.dao;

import org.springframework.stereotype.Component;

import br.com.paintball.model.entity.Room;

@Component
public class HostDao extends GenericDao<Room> {
	
	/*private GenericDao genericDao;

	@Autowired
	public HostDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}	

	public Room createRoom(Long key) {
		Room room = new Room(key, EnumStatus.INATIVO.getStatus(), new HashSet<User>());
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
		Room room = new Room(roomKey, null, null);
		return (Room) this.genericDao.findById(Room.class.getName(), room);
	}*/
	
}
