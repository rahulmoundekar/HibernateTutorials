package com.hibernate.apps;

// PhoneNumber.java (Child Pojo class)

public class PhoneNumber {
	private String numberType;
	private long phone;
	private long id;
	User parent;

	public PhoneNumber() {
		System.out.println("0-arg constructor :PhoneNumber");
	}

	// write getXxx(),setXxx() methods (4 sets)

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public User getParent() {
		return parent;
	}

}
