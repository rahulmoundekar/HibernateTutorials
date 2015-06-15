package com.hibernate.apps;

public class Employee extends Person {
	private double salary;
	private int department;

	public void setSalary(double d) {
		salary = d;
	}

	public double getSalary() {
		return salary;
	}

	public void setDepartment(int n) {
		department = n;
	}

	public int getDepartment() {
		return department;
	}

}
