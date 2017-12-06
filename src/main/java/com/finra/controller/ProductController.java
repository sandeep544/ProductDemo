package com.finra.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finra.email.Email;
import com.finra.inventory.service.Inventory;
import com.finra.payment.service.Payment;

@RestController
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private Inventory inventory;

	@Autowired
	private Payment payment;

	@Autowired
	private Email email;


	@RequestMapping(value = "/product/{id}/{qty}/{creditCard}", method = RequestMethod.GET)
	public String OrderPlaced(@PathVariable("productId") String id, @PathVariable("qty") int qty,
			@PathVariable("creditCard") String creditcardnumber) throws MessagingException {
		log.debug("Received request for Product by id: {}", id);
		boolean inventoryStatus = false;
		boolean paymentStatus = false;
		String result = null;
		inventoryStatus = inventory.CheckInventory(id, qty);
		if (inventoryStatus) {
			Double amount = 100.15;
			paymentStatus = payment.ChargePayment(creditcardnumber, amount);

			if (paymentStatus) {
				log.info("Sending Email notification to shipping department");
				email.sendEmail(id, qty);
				result = "Sending Email notification to shipping department";

			} else {
				log.info("Credit card transaction has failed");
				result = "Credit card transaction has failed";
			}
		} else {
			log.debug("Product does not exist in Inventory: {}", id);
			result = "Product does not exist in Inventory";
		}
		return result;
	}

}
