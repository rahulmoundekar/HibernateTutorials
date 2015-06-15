package com.annotation.apps;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_PAYMENT1")
public class CreditCardPayment extends Payment {
	@Column(name = "cctype")
	private String cardType;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}