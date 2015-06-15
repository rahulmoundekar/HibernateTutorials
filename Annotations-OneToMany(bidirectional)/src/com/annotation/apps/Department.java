package com.annotation.apps;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT1")
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "DEPT_NAME")
	private String departmentName;

	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;

	public Long getDepartmentID() {
		return departmentId;
	}

	public void setDepartmentId(Long s1) {
		departmentId = s1;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String s2) {
		departmentName = s2;
	}
}