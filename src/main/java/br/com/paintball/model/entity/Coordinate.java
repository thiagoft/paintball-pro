package br.com.paintball.model.entity;

public class Coordinate {
	
	private Double latitude;
	private Double longitude;
	
	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	public Coordinate(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordinate() {
	}

}
