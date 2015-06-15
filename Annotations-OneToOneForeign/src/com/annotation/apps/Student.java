package com.annotation.apps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@Column(name = "sid")
	private Integer studentId;

	@Column(name = "sname")
	private String StudentName;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id", referencedColumnName = "addressid")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}
}