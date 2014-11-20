package br.com.paintball.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="ROOM")
public class Room {

	private Long roomKey;
	private Integer status;
	private Set<User> userList;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "CD_ROOM", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getRoomKey() {
		return roomKey;
	}
	
	@Column(name = "FG_STATUS", precision = 1, scale = 0)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<User> getUserList() {
		return userList;
	}

	@Column(name = "VL_PASSWORD", length = 15)
	public String getPassword() {
		return password;
	}
	
	public Room(Long roomKey, Integer status, Set<User> userList) {
		this.roomKey = roomKey;
		this.status = status;
		this.userList = userList;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
