package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.vo.Address;
import com.training.vo.User;
import com.training.util.DatabaseUtil;

public class AddressDAO {

	Connection con = null;

	public AddressDAO() {
		con = DatabaseUtil.getDatabaseConnection();
	}

	public boolean addAddress(List<Address> addresses) {
		String query = "INSERT INTO address_details (user_id, street, city, country) " + "VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			for (Address address : addresses) {
				stmt = con.prepareStatement(query);
				stmt.setInt(1, address.getUserId());
				stmt.setString(2, address.getStreet());
				stmt.setString(3, address.getCity());
				stmt.setString(4, address.getCountry());

				int result = stmt.executeUpdate();
				if (result == 1)
					System.out.println("User is added.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Address> getAddressFromUserId(int userId) {
		String query = "select * from address_details where user_id = ?";
		ArrayList<Address> addresses = null;
		Address address = null;
		try {
			addresses = new ArrayList<Address>();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				address = new Address();
				address.setAddressId(rs.getInt("address_id"));
				address.setUserId(rs.getInt("user_id"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setCountry(rs.getString("country"));
				addresses.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}

	public boolean editAddress(List<Address> addresses) {
		String query = "UPDATE address_details SET street = ?, city = ?, country = ? WHERE address_id = ?;";
		try {
			for (Address address : addresses) {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, address.getStreet());
				stmt.setString(2, address.getCity());
				stmt.setString(3, address.getCountry());
				stmt.setInt(4, address.getAddressId());

				int result = stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteUser(int userId) {
		String query = "DELETE FROM address_details WHERE user_id=?;";
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
	
	public boolean deleteAddress(List<String> addressIds) {
		String query = "DELETE FROM address_details WHERE address_id = ?;";
		int result = 0;
		try {
			for(String addressId : addressIds) {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, addressId);

				result = stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
