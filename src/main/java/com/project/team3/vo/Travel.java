package com.project.team3.vo;

public class Travel {
	
	public int travelId;
	public String travelName;
	public double lat;
	public double lon;
	public String icon;
	public int hotspot;
	
	
	public Travel(int travelId, String travelName, double lat, double lon, String icon, int hotspot) {
		this.travelId = travelId;
		this.travelName = travelName;
		this.lat = lat;
		this.lon = lon;
		this.icon = icon;
		this.hotspot = hotspot;
	}
	@Override
	public String toString() {
		return "Travel [travelId=" + travelId + ", travelName=" + travelName + ", lat=" + lat + ", lon=" + lon + ", icon=" + icon + ", hotspot="
				+ hotspot + "]";
	}
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public String getTravelName() {
		return travelName;
	}
	public void setTravelName(String travelName) {
		this.travelName = travelName;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getHotspot() {
		return hotspot;
	}
	public void setHotspot(int hotspot) {
		this.hotspot = hotspot;
	}
}
