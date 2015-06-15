package com.hibernate.apps;

//User.java (Parent POJO class)

import java.util.*;

public class User {

	private long userId;
	private String firstName;
	private Set phones;

	// wrtie setXxx(-), getXxx() methods
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Set getPhones() {
		return phones;
	}

	public void setPhones(Set phones) {
		this.phones = phones;
	}
}// class

