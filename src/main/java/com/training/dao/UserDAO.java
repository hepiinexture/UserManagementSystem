package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.vo.User;
import com.training.util.DatabaseUtil;

public class UserDAO {

	Connection con = null;

	public UserDAO() {
		con = DatabaseUtil.getDatabaseConnection();
	}

	public boolean loginUser(String username, String password) {
		String query = "select * from user where username = ? and password = ?";
		boolean isValid = false;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				isValid = true;
		} catch (SQLException e) {
			isValid = false;
			e.printStackTrace();
		}
		return isValid;
	}

	public boolean registerUser(User user) {
		String query = "INSERT INTO user (username, email, phone_number, password, type) " + "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPhoneNumber());
			stmt.setString(4, user.getPassword());
			stmt.setBoolean(5, user.isType());

			int result = stmt.executeUpdate();
			if (result == 1)
				System.out.println("User is added.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean editUser(User user) {
		String query = "UPDATE user SET username = ?, email = ?, phone_number = ?, type = ? WHERE user_id = ?;";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPhoneNumber());
			stmt.setBoolean(4, user.isType());
			stmt.setInt(5, user.getUserId());

			int result = stmt.executeUpdate();
			if (result == 1)
				System.out.println("User is added.");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean changePassword(String username, String password) throws Exception {
		String query = null;
		boolean result = false;
		try {
			query = "select * from user where username = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);

			if (stmt.executeQuery().next()) {
				query = "UPDATE user SET password = ? WHERE username = ?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, password);
				stmt.setString(2, username);
				if (stmt.executeUpdate() == 1)
					result = true;
			} else {
				throw new Exception("Invalid username entered");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public User getUserDetailFromUsername(String username) {
		String query = "select * from user where username = ?";
		User user = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setType(rs.getBoolean("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> usersList() {
		String query = "select * from user";
		List<User> users = null;
		User user = null;
		try {
			users = new ArrayList<User>();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setType(false);
				user.setPhoneNumber(rs.getString("phone_number"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserFromUserId(int userId) {
		String query = "select * from user where user_id = ?";
		User user = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setType(rs.getBoolean("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(int userId) {
		String query = "DELETE FROM user WHERE user_id=?;";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);

			int result = stmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
