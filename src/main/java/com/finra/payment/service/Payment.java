package com.finra.payment.service;

public interface Payment {

	boolean ChargePayment(String creditcardnumber, Double amount);

}
