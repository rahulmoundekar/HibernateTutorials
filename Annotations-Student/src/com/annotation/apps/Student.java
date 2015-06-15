package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "Student")
class Student {
	int sno;
	String sname;
	String addr;

	public void setSno(Integer x) {
		sno = x;
	}

	@Id
	@Column(name = "sno")
	public Integer getSno() {
		return sno;
	}

	public void setSname(String y) {
		sname = y;
	}

	@Column(name = "sname")
	// @Transient
	public String getSname() {
		return sname;
	}

	public void setAddr(String z) {
		addr = z;
	}

	@Column(name = "addr")
	// @Transient
	public String getAddr() {
		return addr;
	}
}
