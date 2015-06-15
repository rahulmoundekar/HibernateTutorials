package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "customers1")
public class Customer {
	@Id
	@Column(name = "custid")
	int customerid;

	@Column(name = "custname")
	String customername;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
}