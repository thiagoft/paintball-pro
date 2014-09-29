package br.com.paintball.model.entity;

public class Coordinate {
	
	private Long latitude;
	private Long longitude;
	
	public Long getLatitude() {
		return latitude;
	}

	public Long getLongitude() {
		return longitude;
	}
	
	public Coordinate(Long latitude, Long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordinate() {
	}

}
