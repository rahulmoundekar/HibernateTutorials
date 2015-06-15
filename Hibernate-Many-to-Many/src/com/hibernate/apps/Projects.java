package com.hibernate.apps;

import java.util.HashSet;
import java.util.Set;

public class Projects implements java.io.Serializable {

	private int prodid;
	private String proname;
	private Set programmers = new HashSet();

	public Projects() {
	}

	public Projects(int prodid, String proname) {
		this.prodid = prodid;
		this.proname = proname;
	}

	public void setProdid(int n) {
		prodid = n;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProname(String s) {
		proname = s;
	}

	public String getProname() {
		return proname;
	}

	public void setProgrammers(Set s) {
		programmers = s;
	}

	public Set getProgrammers() {
		return programmers;
	}
}
