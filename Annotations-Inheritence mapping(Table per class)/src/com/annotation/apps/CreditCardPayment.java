package com.annotation.apps;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "CREDIT")
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