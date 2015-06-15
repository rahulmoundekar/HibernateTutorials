package com.hibernate.apps;

public class Sessions {
	private int sesid;
	private String sesname;

	public void setSesid(int n) {
		sesid = n;
	}

	public int getSesid() {
		return sesid;
	}

	public void setSesname(String s) {
		sesname = s;
	}

	public String getSesname() {
		return sesname;
	}
}