package br.com.paintball.model.business;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.dao.HostDao;
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
				room = this.hostDao.createRoom(new Long(randomNumber.nextInt(10000)));
			} while (room == null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public Room findRoom(Long roomKey) {
		try {
			return this.hostDao.findRoom(roomKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
