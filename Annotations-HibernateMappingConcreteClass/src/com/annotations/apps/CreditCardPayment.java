package com.annotations.apps;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_PAYMENT2")
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