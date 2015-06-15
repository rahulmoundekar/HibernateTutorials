package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Payment {
	@Id
	@Column(name = "payid")
	private Integer paymentId;
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getPaymentID() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
}
