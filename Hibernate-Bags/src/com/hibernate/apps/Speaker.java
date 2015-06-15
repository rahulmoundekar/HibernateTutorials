package com.hibernate.apps;

import java.util.*;
public class Speaker {

	private int sid;
	private String sname;
	private List sessions = new ArrayList();
	private List phonenumbers = new ArrayList();

	public void setSid(int n) {
		sid = n;
	}

	public int getSid() {
		return sid;
	}

	public void setSname(String s) {
		sname = s;
	}

	public String getSname() {
		return sname;
	}

	public void setSessions(List l) {
		sessions = l;
	}

	public List getSessions() {
		return sessions;
	}

	public void setPhonenumbers(List l) {
		phonenumbers = l;
	}

	public List getPhonenumbers() {
		return phonenumbers;
	}
}
