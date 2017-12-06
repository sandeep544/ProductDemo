package com.finra.email;

import javax.mail.MessagingException;

public interface Email {

	public void sendEmail(String id, int qty) throws MessagingException;

}
