package com.hibernate.apps;

public class Employee1 implements java.io.Serializable {

	private int eid;
	private String fname;
	private String lname;
	private String email;

	public Employee1() {
	}

	public Employee1(int eid) {
		this.eid = eid;
	}

	public Employee1(int eid, String fname, String lname, String email) {
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
