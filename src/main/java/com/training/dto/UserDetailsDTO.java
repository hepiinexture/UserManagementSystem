package com.training.dto;

import java.util.ArrayList;

import com.training.vo.Address;
import com.training.vo.User;

public class UserDetailsDTO {

	private User user;
	private ArrayList<Address> addresses;

	public UserDetailsDTO() {
		super();
	}

	public UserDetailsDTO(User user, ArrayList<Address> addresses) {
		super();
		this.user = user;
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Address> getAddress() {
		return addresses;
	}

	public void setAddress(ArrayList<Address> address) {
		this.addresses = address;
	}

	@Override
	public String toString() {
		return "UserDTO [user=" + user + ", addresses=" + addresses + "]";
	}

}
