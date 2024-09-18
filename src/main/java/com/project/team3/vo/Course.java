package com.project.team3.vo;

public class Course {
	public Course(int courseId, String courseName, double attraction1Lon, double attraction1Lat, String attraction1Name,
			double attraction2Lon, double attraction2Lat, String attraction2Name, double attraction3Lon,
			double attraction3Lat, String attraction3Name) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.attraction1Lon = attraction1Lon;
		this.attraction1Lat = attraction1Lat;
		this.attraction1Name = attraction1Name;
		this.attraction2Lon = attraction2Lon;
		this.attraction2Lat = attraction2Lat;
		this.attraction2Name = attraction2Name;
		this.attraction3Lon = attraction3Lon;
		this.attraction3Lat = attraction3Lat;
		this.attraction3Name = attraction3Name;
	}
	public int courseId;
	public String courseName;
	public double attraction1Lon;
	public double attraction1Lat;
	public String attraction1Name;
	public double attraction2Lon;
	public double attraction2Lat;
	public String attraction2Name;
	public double attraction3Lon;
	public double attraction3Lat;
	public String attraction3Name;
	public double averageRating;
	
	
	
	public Course(int courseId, String courseName, double attraction1Lon, double attraction1Lat, String attraction1Name,
			double attraction2Lon, double attraction2Lat, String attraction2Name, double attraction3Lon,
			double attraction3Lat, String attraction3Name, double averageRating) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.attraction1Lon = attraction1Lon;
		this.attraction1Lat = attraction1Lat;
		this.attraction1Name = attraction1Name;
		this.attraction2Lon = attraction2Lon;
		this.attraction2Lat = attraction2Lat;
		this.attraction2Name = attraction2Name;
		this.attraction3Lon = attraction3Lon;
		this.attraction3Lat = attraction3Lat;
		this.attraction3Name = attraction3Name;
		this.averageRating = averageRating;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getAttraction1Name() {
		return attraction1Name;
	}

	public void setAttraction1Name(String attraction1Name) {
		this.attraction1Name = attraction1Name;
	}

	public String getAttraction2Name() {
		return attraction2Name;
	}

	public void setAttraction2Name(String attraction2Name) {
		this.attraction2Name = attraction2Name;
	}

	public String getAttraction3Name() {
		return attraction3Name;
	}

	public void setAttraction3Name(String attraction3Name) {
		this.attraction3Name = attraction3Name;
	}

	public Course(int courseId, String courseName, double attraction1Lon, double attraction1Lat, double attraction2Lon,
			double attraction2Lat, double attraction3Lon, double attraction3Lat) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.attraction1Lon = attraction1Lon;
		this.attraction1Lat = attraction1Lat;
		this.attraction2Lon = attraction2Lon;
		this.attraction2Lat = attraction2Lat;
		this.attraction3Lon = attraction3Lon;
		this.attraction3Lat = attraction3Lat;
	}
	
	@Override
	public String toString() {
		return "Course [couseId=" + courseId + ", courseName=" + courseName + ", attraction1Lon=" + attraction1Lon
				+ ", attraction1Lat=" + attraction1Lat + ", attraction1Name=" + attraction1Name + ", attraction2Lon="
				+ attraction2Lon + ", attraction2Lat=" + attraction2Lat + ", attraction2Name=" + attraction2Name
				+ ", attraction3Lon=" + attraction3Lon + ", attraction3Lat=" + attraction3Lat + ", attraction3Name="
				+ attraction3Name + "]";
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCouseId(int couseId) {
		this.courseId = couseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getAttraction1Lon() {
		return attraction1Lon;
	}
	public void setAttraction1Lon(double attraction1Lon) {
		this.attraction1Lon = attraction1Lon;
	}
	public double getAttraction1Lat() {
		return attraction1Lat;
	}
	public void setAttraction1Lat(double attraction1Lat) {
		this.attraction1Lat = attraction1Lat;
	}
	public double getAttraction2Lon() {
		return attraction2Lon;
	}
	public void setAttraction2Lon(double attraction2Lon) {
		this.attraction2Lon = attraction2Lon;
	}
	public double getAttraction2Lat() {
		return attraction2Lat;
	}
	public void setAttraction2Lat(double attraction2Lat) {
		this.attraction2Lat = attraction2Lat;
	}
	public double getAttraction3Lon() {
		return attraction3Lon;
	}
	public void setAttraction3Lon(double attraction3Lon) {
		this.attraction3Lon = attraction3Lon;
	}
	public double getAttraction3Lat() {
		return attraction3Lat;
	}
	public void setAttraction3Lat(double attraction3Lat) {
		this.attraction3Lat = attraction3Lat;
	}
}
