package com.annotation.apps;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "vendor1")
public class Vendor {
	int vendorid;
	String vendorname;
	Set children;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendid", referencedColumnName = "vid")
	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	@Id
	@Column(name = "vid")
	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	@Column(name = "vname")
	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
}