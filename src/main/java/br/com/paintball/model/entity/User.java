package br.com.paintball.model.entity;

import com.google.gson.Gson;


public class User {
	
	private Long userId;
	private String userName;
	private Coordinate coordinate;
	private Integer userClass;
	private Long roomKey;
	private Commands commands;
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Long getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public Integer getUserClass() {
		return userClass;
	}

	public Long getRoomKey() {
		return roomKey;
	}

	public Commands getCommands() {
		return commands;
	}

	public User(Long userId, String userName, Coordinate coordinate, Integer userClass, Long roomKey, Commands commands) {
		this.userId = userId;
		this.userName = userName;
		this.coordinate = coordinate;
		this.userClass = userClass;
		this.commands = commands;
	}
	
	public User(String userName, Coordinate coordinate, Integer userClass, Long roomKey, Commands commands) {
		this.userName = userName;
		this.coordinate = coordinate;
		this.userClass = userClass;
		this.roomKey = roomKey;
		this.commands = commands;
	}
	
	public User() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomKey == null) ? 0 : roomKey.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (roomKey == null) {
			if (other.roomKey != null)
				return false;
		} else if (!roomKey.equals(other.roomKey))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
