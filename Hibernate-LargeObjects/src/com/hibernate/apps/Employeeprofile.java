package com.hibernate.apps;

import java.sql.Blob;
import java.sql.Clob;

public class Employeeprofile implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empid;
	private String ename;
	private Clob empresume;
	private Blob empphoto;

	public Employeeprofile() {
	}

	public Employeeprofile(int empid) {
		this.empid = empid;
	}

	public Employeeprofile(int empid, String ename, Clob empresume,
			Blob empphoto) {
		this.empid = empid;
		this.ename = ename;
		this.empresume = empresume;
		this.empphoto = empphoto;
	}

	public int getEmpid() {
		return this.empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Clob getEmpresume() {
		return this.empresume;
	}

	public void setEmpresume(Clob empresume) {
		this.empresume = empresume;
	}

	public Blob getEmpphoto() {
		return this.empphoto;
	}

	public void setEmpphoto(Blob empphoto) {
		this.empphoto = empphoto;
	}
}
