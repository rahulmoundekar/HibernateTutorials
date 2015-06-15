package com.hibernate.apps;

public class Account implements java.io.Serializable {

	/**
	 * @author RAHUL
	 */
	private static final long serialVersionUID = 1L;
	private int acno;
	private String holdername;
	private Double balance;

	public Account() {
	}

	public Account(int acno) {
		this.acno = acno;
	}

	public Account(int acno, String holdername, Double balance) {
		this.acno = acno;
		this.holdername = holdername;
		this.balance = balance;
	}

	public int getAcno() {
		return this.acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getHoldername() {
		return this.holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
