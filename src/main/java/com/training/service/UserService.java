package com.training.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.dao.AddressDAO;
import com.training.dao.UserDAO;
import com.training.dto.AddressDTO;
import com.training.dto.UserDTO;
import com.training.dto.UserDetailsDTO;
import com.training.mapping.AddressMapping;
import com.training.vo.Address;
import com.training.vo.User;

public class UserService {

	UserDAO userDAO = null;
	AddressDAO addressDAO = null;

	public UserService() {
		userDAO = new UserDAO();
		addressDAO = new AddressDAO();
	}

	public User loginUser(String username, String password) {
		boolean isValidUser = false;
		User user = null;
		try {
			isValidUser = userDAO.loginUser(username, password);

			if (!isValidUser)
				throw new Exception("Invalid username and password");
			user = getUserDetailFromUsername(username);
		} catch (Exception e) {
			isValidUser = false;
			e.printStackTrace();
		}
		return user;
	}

	public void registerUser(User user) {
		userDAO.registerUser(user);
		int userId = userDAO.getUserDetailFromUsername(user.getUsername()).getUserId();
		for(Address address : user.getAddress()) {
			address.setUserId(userId);
		}
		addressDAO.addAddress(user.getAddress());
	}

	public void addAddress(List<Address> addresses) {
		addressDAO.addAddress(addresses);
	}

	public boolean editUserDetails(User user, AddressDTO addressDTO) {
		userDAO.editUser(user);
		ArrayList<Address> addresses = AddressMapping.map(addressDTO);
		return addressDAO.editAddress(addresses);
	}
	
	public boolean editAddress(User user) {
		userDAO.editUser(user);
		return addressDAO.editAddress(user.getAddress());
	}
	
	public User getUserDetailFromUsername(String username) {
		return userDAO.getUserDetailFromUsername(username);
	}
	
	public String changePassword(String password, String confirmPassword, String username) {
		String message = null;
		try {
			if (!password.equals(confirmPassword))
				throw new Exception("Password and Confirm Password must be same.");
			boolean result = userDAO.changePassword(username, password);
			if(result)
				message = "changed";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		return message;
	}

	public List<User> usersList() {
		return userDAO.usersList();
	}

	public User getUserFromUserId(int userId) {
		return userDAO.getUserFromUserId(userId);
	}

	public UserDetailsDTO getUserDetailFromUserId(int userId) {
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setUser(userDAO.getUserFromUserId(userId));
		userDetailsDTO.setAddress(addressDAO.getAddressFromUserId(userId));
		return userDetailsDTO;
	}
	
	public ArrayList<Address> getAddressFromUserId(int userId) {
		return addressDAO.getAddressFromUserId(userId);
	}

	public boolean deleteAddresses(List<String> addressIds) {
		boolean result = addressDAO.deleteAddress(addressIds);
		if(result)
			System.out.println("Record Deleted Successfully...");
		return true;
	}
	
	public boolean deleteUserDetails(int userId) {
		boolean result = addressDAO.deleteUser(userId);
		if(result)
			result = userDAO.deleteUser(userId);
		System.out.println("Record Deleted Successfully...");
		return true;
	}

}
