package com.hibernate.apps;

//User.java (parent pojo class)
import java.util.*;

public class User {

	private long userId;
	private String firstName;
	private Set phones;

	public User() {
		System.out.println("0-arg constructor :User");
	}

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
}
