package com.finra.payment.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentImpl implements Payment {

	@Override
	public boolean ChargePayment(String creditcardnumber, Double amount) {
		// need to call third party url for making payment transaction by
		// passing creditcard and amount. if it returns success returns true
		return true;
	}

}
