package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "Address41")
public class Address {

	@Id
	@Column(name = "addressId")
	private Integer addressId;

	@Column(name = "place")
	private String place;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
