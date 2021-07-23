package com.training.vo;

import java.util.List;

public class User {

	private int userId;
	private String username;
	private String email;
	private String password;
	private String phoneNumber;
	private boolean type;
	private List<Address> addresses;
	
	public User() {
		super();
	}

	public User(String username, String email, String password, String phoneNumber, boolean type,
			List<Address> addresses) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.addresses = addresses;
	}

	public User(int userId, String username, String email, String password, String phoneNumber, boolean type,
			List<Address> addresses) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.addresses = addresses;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public List<Address> getAddress() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", type=" + type + ", addresses=" + addresses + "]";
	}

}
