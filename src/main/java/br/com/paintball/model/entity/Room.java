package br.com.paintball.model.entity;

import java.util.Set;

public class Room {

	public Room(Long roomKey, Integer status, Set<User> userList) {
		this.roomKey = roomKey;
		this.status = status;
		this.userList = userList;
	}
	
	private Long roomKey;
	private Integer status;
	private Set<User> userList;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getRoomKey() {
		return roomKey;
	}
	public Set<User> getUserList() {
		return userList;
	}
	
}
