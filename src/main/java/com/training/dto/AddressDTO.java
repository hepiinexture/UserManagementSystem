package com.training.dto;

public class AddressDTO {

	private String addressId;
	private String userId;
	private String street;
	private String city;
	private String country;
	
	public AddressDTO() {
		super();
	}

	public AddressDTO(String userId, String street, String city, String country) {
		super();
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	public AddressDTO(String addressId, String userId, String street, String city, String country) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
