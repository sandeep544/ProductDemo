package com.finra.product;
import static org.junit.Assert.*;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.finra.controller.ProductController;

public class ProductControllerRestTest {
	
	@Autowired
	private ProductController productController;

	@Test
	public void positiveTest() throws MessagingException {
		String result = productController.OrderPlaced("1", 1, "123456789");
		assertEquals("Sending Email notification to shipping department", result);
	}
	
	@Test
	public void negitiveTest() throws MessagingException {
		String result = productController.OrderPlaced("1", 101, "123456789");
		assertEquals("Product quantity does not exist in Inventory", result);
	}

}
