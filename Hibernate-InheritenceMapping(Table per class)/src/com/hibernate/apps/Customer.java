package com.hibernate.apps;

public class Customer extends Person {
	private String address;

	public void setAddress(String s) {
		address = s;
	}

	public String getAddress() {
		return address;
	}

}
