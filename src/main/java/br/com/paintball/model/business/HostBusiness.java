package br.com.paintball.model.business;

import java.util.HashSet;
import java.util.Random;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.dao.HostDao;
import br.com.paintball.enums.EnumStatus;
import br.com.paintball.model.entity.Room;

@Component
public class HostBusiness {
	
	private HostDao hostDao;

	@Autowired
	public HostBusiness(HostDao hostDao) {
		this.hostDao = hostDao;
	}

	public Room createRoom() {
		Random randomNumber = new Random();
		Room room = null;
		try {
			do {
				//room = new Room(, EnumStatus.INATIVO.getStatus(), new HashSet<User>());
				room = new Room(new Long(randomNumber.nextInt(10000)), EnumStatus.INATIVO.getStatus(), null);
				this.hostDao.insert(room);
			} while (room == null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public Room findRoom(Long roomKey) {
		try {
			return this.hostDao.findById(roomKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
