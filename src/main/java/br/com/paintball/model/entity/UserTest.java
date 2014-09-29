package br.com.paintball.model.entity;

import com.google.gson.Gson;

public class UserTest {
	private Long userId;
	private Float latitude;
	private Float longitude;
	
	public Long getUserId() {
		return userId;
	}
	public Float getLatitude() {
		return latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	
	public UserTest(Long userId, Float latitude, Float longitude) {
		this.userId = userId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public UserTest() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
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
		UserTest other = (UserTest) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserTest [userId=" + userId + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	public String toJSON() {
		return new Gson().toJson(this);
	}
}
