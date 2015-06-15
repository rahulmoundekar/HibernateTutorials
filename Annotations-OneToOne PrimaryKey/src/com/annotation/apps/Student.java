package com.annotation.apps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "StudentAnnotation")
public class Student {

	@Id
	@GeneratedValue(generator = "gen1")
	@GenericGenerator(name = "gen1", strategy = "increment")
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "address")
	private String address;
	// @OneToOne(mappedBy="student")
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Library library;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}