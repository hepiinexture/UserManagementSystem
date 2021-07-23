package com.training.mapping;

import java.util.ArrayList;
import java.util.Iterator;

import com.training.dto.AddressDTO;
import com.training.vo.Address;

public class AddressMapping {

	public static ArrayList<Address> map(AddressDTO addressDTO) {
		Address address = null;
		ArrayList<Address> addresses = null;
		try {
			addresses = new ArrayList<Address>();
			String[] addressIds = addressDTO.getAddressId().split(",");
			String[] userIds = addressDTO.getUserId().split(",");
			String[] streets = addressDTO.getStreet().split(",");
			String[] cities = addressDTO.getCity().split(",");
			String[] countries = addressDTO.getCountry().split(",");
			int i=0;
			for(String addressId : addressIds) {
				address = new Address();
				address.setAddressId(Integer.parseInt(addressId));
				address.setUserId(Integer.parseInt(userIds[i]));
				address.setStreet(streets[i]);
				address.setCity(cities[i]);
				address.setCountry(countries[i]);
				addresses.add(address);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}
	
}
