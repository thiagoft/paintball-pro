package br.com.paintball.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.Gson;

@Entity
@Table(name="USER")
public class User {
	
	private Long userId;
	private String userName;
	private Coordinate coordinate;
	private Integer userClass;
	private Long roomKey;
	private Commands commands;
	private Date lastSend;
	private Double latitude;
	private Double longitude;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "CD_USER", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getUserId() {
		return userId;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CD_COORDINATE", nullable = false)
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	@Column(name = "DESC_USER", nullable = false, length = 15)
	public String getUserName() {
		return userName;
	}

	@Column(name = "FG_CLASS", nullable = false, precision = 1, scale = 0)
	public Integer getUserClass() {
		return userClass;
	}

	@Column(name = "CD_ROOM_KEY", precision = 11, scale = 0)
	public Long getRoomKey() {
		return roomKey;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CD_COMMAND", nullable = false)
	public Commands getCommands() {
		return commands;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_HR_LAST_SEND", nullable = false)
	public Date getLastSend() {
		return lastSend;
	}

	public void setLastSend(Date lastSend) {
		this.lastSend = lastSend;
	}

	@Column(name = "VL_LATITUDE", precision = 10, scale = 10)
	public Double getLatitude() {
		return latitude;
	}

	@Column(name = "VL_LONGITUDE", precision = 10, scale = 10)
	public Double getLongitude() {
		return longitude;
	}

	public User(Long userId, String userName, Coordinate coordinate, Integer userClass, Long roomKey, 
				Commands commands, Date lastSend) {
		this.userId = userId;
		this.userName = userName;
		this.coordinate = coordinate;
		this.userClass = userClass;
		this.roomKey = roomKey;
		this.commands = commands;
		this.lastSend = lastSend;
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
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
