package com.hibernate.apps;

import java.util.HashSet;
import java.util.Set;

public class Programmers {

	private int pid;
	private String pname;
	private double salary;
	private Set projects = new HashSet();

	public Programmers() {
	}

	public Programmers(int pid, String pname, double salary) {
		this.pid = pid;
		this.pname = pname;
		this.salary = salary;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int n) {
		pid = n;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String s) {
		pname = s;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double n) {
		salary = n;
	}

	public void setProjects(Set s) {
		projects = s;
	}

	public Set getProjects() {
		return projects;
	}

}
