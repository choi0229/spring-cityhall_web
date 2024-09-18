package com.project.team3.vo;

import java.sql.Timestamp;

public class Comment {
	
	public int commentId;
	public String details;
	public String userId;
	public int courseId;
	public double rating;
	public Timestamp time;
	
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", details=" + details + ", userId=" + userId + ", courseId="
				+ courseId + ", rating=" + rating + ", time=" + time + "]";
	}
	public Comment(int commentId, String details, String userId, int courseId, double rating, Timestamp time) {
		super();
		this.commentId = commentId;
		this.details = details;
		this.userId = userId;
		this.courseId = courseId;
		this.rating = rating;
		this.time = time;
	}
	
	public Comment(String details, String userId, int courseId, double rating) {
		this.details = details;
		this.userId = userId;
		this.courseId = courseId;
		this.rating = rating;
	}
	
	public Comment(String details, int commentId) {
		this.details = details;
		this.commentId = commentId;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
