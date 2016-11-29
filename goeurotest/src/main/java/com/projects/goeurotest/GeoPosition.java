package com.projects.goeurotest;

public class GeoPosition {
	
	private Double latitute;
	private Double longitude;
	
	public GeoPosition(Double string, Double string2) {
		this.latitute=string;
		this.longitude=string2;
	}
	
	public Double getLatitute() {
		return latitute;
	}
	
	public void setLatitute(Double latitute) {
		this.latitute = latitute;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
