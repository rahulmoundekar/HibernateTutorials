package com.hibernate.apps;

public class Person {
	private int id;
	private String name, company;

	public void setId(int n) {
		id = n;
	}

	public int getId() {
		return id;
	}

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public void setCompany(String s) {
		company = s;
	}

	public String getCompany() {
		return company;
	}
}
