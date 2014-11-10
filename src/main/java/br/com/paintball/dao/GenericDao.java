package br.com.paintball.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.paintball.interfaces.IDao;

@Repository
@SuppressWarnings("unchecked")
public abstract class GenericDao<T> implements IDao<T>{
	
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(T obj) {
		entityManager.persist(obj);		
	}

	public void update(T obj) {
		entityManager.merge(obj);		
	}
	
	public T findById(Long id) {
		return (T) entityManager.find(getTypeClass(), id);
    }

	public List<T> list() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

	public void remove(T obj) {
		entityManager.remove(obj);
	}	
	
	private Class<?> getTypeClass() {
		Class<?> entity = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return entity;
	}
	

	/*public static final Map<Long,Set<User>> userMap;
	public static Long userSequence;
	
	static {
		userMap = new HashMap<Long,Set<User>>();
		userSequence = 0l;
	}
	
	public boolean save(String name, Object obj) {
		userMap.put(((Room) obj).getRoomKey(), new HashSet<User>());
		return true;
	}
	
	public Object update(String name, Object obj) {
		User user = (User) obj;
		Room room = null;
		if (userMap.containsKey(user.getRoomKey())) {
			for (User instantUser : userMap.get(user.getRoomKey())) {
				if (user.equals(instantUser)) {
					userMap.get(user.getRoomKey()).remove(instantUser);
					userMap.get(user.getRoomKey()).add(user);
					room = new Room(user.getRoomKey(),EnumStatus.ATIVO.getStatus(),userMap.get(user.getRoomKey()));
					break;
				} else {
					room = null;
				}
			}
			return room;
		} else {
			return null;
		}
	}
	
	public boolean remove(String name, Object obj) {
		User user = (User) obj;
		boolean isRemoved = false;
		if (userMap.containsKey(user.getRoomKey())) {
			for (User instantUser : userMap.get(user.getRoomKey())) {
				if (user.equals(instantUser)) {
					userMap.get(user.getRoomKey()).remove(instantUser);
					isRemoved = true;
					break;
				} else {
					isRemoved = false;
				}
			}
		} else {
			isRemoved = false;
		}
		return isRemoved;
	}
	
	public Object insert(String name, Object obj) {
		User user = (User) obj;
		if (userMap.containsKey(user.getRoomKey())) {
			if (user.getUserId() != null){
				user = (User) this.update(User.class.getName(), user);
			} else {
				user = new User(++userSequence, user.getUserName(), user.getCoordinate(), user.getUserClass(),
						user.getRoomKey(), user.getCommands(), user.getLastSend());
				userMap.get(user.getRoomKey()).add(user);
			}
			return user;
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
	}*/


}
