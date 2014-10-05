package br.com.paintball.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import enums.EnumStatus;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

@Repository
public class GenericDao {
	
	public static final Map<Long,Set<User>> userMap;
	
	static {
		userMap = new HashMap<Long,Set<User>>();
	}
	
	public boolean save(String name, Object obj) {
		userMap.put(((Room) obj).getRoomKey(), new HashSet<User>());
		return true;
	}
	
	public Object update(String name, Object obj) {
		User user = (User) obj;
		if (userMap.containsKey(user.getRoomKey())) {
			for (User instantUser : userMap.get(user.getRoomKey())) {
				if (user.equals(instantUser)) {
					userMap.get(user.getRoomKey()).remove(instantUser);
					userMap.get(user.getRoomKey()).add(user);
					break;
				}
			}
			userMap.get(user.getRoomKey()).add(user);
			return new Room(user.getRoomKey(),EnumStatus.ATIVO.getStatus(),userMap.get(user.getRoomKey()));
		} else {
			return null;
		}
	}
	
	public Object findById(String name, Object obj) {
		Room room = (Room) obj;
		if (userMap.containsKey(room.getRoomKey())) {
			return new Room(room.getRoomKey(), room.getStatus(), userMap.get(room.getRoomKey()));
		} else {
			return null;
		}
	}
	
	/*public void addUser(UserTest userTest) {
		if (userMap.containsKey(userTest.getUserId())) {
			userMap.get(userTest.getUserId()).add(userTest);
		} else {
			userMap.put(userTest.getUserId(), new HashSet<UserTest>());
			userMap.get(userTest.getUserId()).add(userTest);
		}
	}
	
	public Set<UserTest> findUserList(Long user) {
		if (userMap.containsKey(user)) {
			return userMap.get(user);
		} else {
			return null;
		}
	}*/
	
}
