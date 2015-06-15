package com.annotation.apps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT")
public class Student implements java.io.Serializable {

	// Fields

	private Integer sno;
	private String sname;
	private String addr;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String sname, String addr) {
		this.sname = sname;
		this.addr = addr;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SNO", unique = true)
	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	@Column(name = "SNAME")
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "ADDR")
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}