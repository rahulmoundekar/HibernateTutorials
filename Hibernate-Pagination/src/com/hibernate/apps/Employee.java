package com.hibernate.apps;

public class Employee {
	// declare Bean Properties
	// Declare member variables
	private int eid;
	private String fname, lname, email;

	// write setXxx(-) and getXxx()
	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEid() {
		return eid;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLname() {
		return lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
