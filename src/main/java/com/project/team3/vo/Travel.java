package com.project.team3.vo;

public class Travel {
	
	public int id;
	public String name;
	public double lat;
	public double lon;
	public String icon;
	public int hotspot;
	
	
	public Travel(int id, String name, double lat, double lon, String icon, int hotspot) {
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.icon = icon;
		this.hotspot = hotspot;
	}
	@Override
	public String toString() {
		return "Travel [id=" + id + ", name=" + name + ", lat=" + lat + ", lon=" + lon + ", icon=" + icon + ", hotspot="
				+ hotspot + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
