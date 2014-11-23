package br.com.paintball.model.entity;

import java.util.Set;

import com.google.gson.Gson;

public class Room {

	public Room(Long roomKey, Integer status, Set<User> userList, Coordinate coordinate) {
		this.roomKey = roomKey;
		this.status = status;
		this.userList = userList;
		this.coordinate = coordinate;
	}
	
	private Long roomKey;
	private Integer status;
	private Coordinate coordinate;
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
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
