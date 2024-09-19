package com.project.team3.vo;

public class Facility {

	
	public String facilityId;
	public String facilityName;
	public String facilityType;
	public double lat;
	public double lon;
	public String facilityImg;
	public String details;
	
	public Facility(String facilityId, String facilityName, String facilityType, double lat, double lon,
			String facilityImg, String details) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityType = facilityType;
		this.lat = lat;
		this.lon = lon;
		this.facilityImg = facilityImg;
		this.details = details;
	}
	
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityImg() {
		return facilityImg;
	}
	public void setFacilityImg(String facilityImg) {
		this.facilityImg = facilityImg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", facilityName=" + facilityName + ", facilityType="
				+ facilityType + ", lat=" + lat + ", lon=" + lon + ", facilityImg=" + facilityImg + ", details="
				+ details + "]";
	}
}
