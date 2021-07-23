package com.training.vo;

public class Address {

	private int addressId;
	private int userId;
	private String street;
	private String city;
	private String country;

	public Address() {
		super();
	}
	
	public Address(int userId, String street, String city, String country) {
		super();
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	public Address(int addressId, int userId, String street, String city, String country) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + userId + ", street=" + street + ", city=" + city
				+ ", country=" + country + "]";
	}

}
