package com.projects.goeurotest;

public class City {
	
	 	private Long Id;
	    private String name;
	    private String fullName;
	    private String iata_airport_code;
	    private String type;
	    private String country;
	    private GeoPosition geoPosition;
	    private int location_id;
	    private boolean inEurope;
	    private String countryCode;
	    private boolean coreCountry;
	    private String distance;
		
	    
	    
	    
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	    public String getDistance() {
				return distance;
			}
		public void setDistance(String string) {
				this.distance = string;
			}
		
		public boolean isCoreCountry() {
				return coreCountry;
			}
		
		public void setCoreCountry(boolean coreCountry) {
				this.coreCountry = coreCountry;
			}
		public Long getId() {
			return Id;
		}
		public void setId(Long long1) {
			Id = long1;
		}
		public String getIata_airport_code() {
			return iata_airport_code;
		}
		public void setIata_airport_code(String iata_airport_code) {
			this.iata_airport_code = iata_airport_code;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public GeoPosition getGeoPosition() {
			return geoPosition;
		}
		public void setGeoPosition(GeoPosition geoPosition) {
			this.geoPosition = geoPosition;
		}
		public int getLocation_id() {
			return location_id;
		}
		public void setLocation_id(int location_id) {
			this.location_id = location_id;
		}
		public boolean isInEurope() {
			return inEurope;
		}
		public void setInEurope(boolean inEurope) {
			this.inEurope = inEurope;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
	     
	   
}
