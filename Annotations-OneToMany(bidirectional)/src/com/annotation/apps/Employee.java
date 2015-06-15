package com.annotation.apps;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE1")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "cell_phone")
	private String cellphone;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {

	}

	public Employee(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = new Date(System.currentTimeMillis());
		this.cellphone = phone;
	}

	public void setEmployeeId(Long k) {
		employeeId = k;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String s1) {
		firstname = s1;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String s2) {
		lastname = s2;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date s3) {
		birthDate = s3;
	}

	public String getCellPhone() {
		return cellphone;
	}

	public void setCellPhone(String s4) {
		cellphone = s4;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}