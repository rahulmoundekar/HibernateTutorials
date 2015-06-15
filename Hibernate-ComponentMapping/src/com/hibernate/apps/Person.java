package com.hibernate.apps;

public class Person {
	private int pid;
	private String pname;
	private JobType pjob;

	public void setPid(int n) {
		pid = n;
	}

	public int getPid() {
		return pid;
	}

	public void setPname(String s) {
		pname = s;
	}

	public String getPname() {
		return pname;
	}

	public void setPjob(JobType j) {
		pjob = j;
	}

	public JobType getPjob() {
		return pjob;
	}
}

/*
 * create table person_tab (pid number(5) primary key, pname varchar2(20), job
 * varchar2(20), salary number(8,2), department number(4) );
 */
