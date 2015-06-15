package com.hibernate.apps;

//PhoneNumber.java (Child POJO class)

public class PhoneNumber {
	private String numberType;
	private long phone;
	private long id;

	// write setXxx(-) and getXxx() methods

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

}
