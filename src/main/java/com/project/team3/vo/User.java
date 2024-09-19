package com.project.team3.vo;

public class User {
	public User(String userId, String userPw, String userName, String userNickname, String userEmail, String userBirth,
			String userAddress) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userAddress = userAddress;
	}

	public String userId;
	public String userPw;
	public String userName;
	public String userNickname;
	public String userEmail;
	public String userBirth;
	public String userAddress;
	public int managerId;

	
	public User(String userId, String userPw, String userName, String userNickname, String userEmail, String userBirth,
			String userAddress, int managerId) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userAddress = userAddress;
		this.managerId = managerId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public User(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = "";
		this.userNickname = "";
		this.userEmail = "";
		this.userBirth = "";
		this.userAddress = "";

	}

	public User() {
		this.userId = "";
		this.userPw = "";
		this.userName = "";
		this.userNickname = "";
		this.userEmail = "";
		this.userBirth = "";
		this.userAddress = "";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userNickname="
				+ userNickname + ", userEmail=" + userEmail + ", userBirth=" + userBirth + ", userAddress="
				+ userAddress + ", managerId=" + managerId + "]";
	}

}