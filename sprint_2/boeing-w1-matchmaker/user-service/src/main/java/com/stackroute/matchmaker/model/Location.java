package com.stackroute.matchmaker.model;

public class Location {
	private String profileId;
	private String address;
	private String city;
	private String pin;
	private String state;
	private String country;

	public Location() {
	}

	public Location(String profileId, String address, String city, String pin, String state, String country) {
		super();
		this.profileId = profileId;
		this.address = address;
		this.city = city;
		this.pin = pin;
		this.state = state;
		this.country = country;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [profileId=" + profileId + ", address=" + address + ", city=" + city + ", pin=" + pin
				+ ", state=" + state + ", country=" + country + "]";
	}

	
}
