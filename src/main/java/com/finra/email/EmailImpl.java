package com.finra.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailImpl implements Email {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String id, int qty) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo("sandeepreddypatolla@gmail.com");
		helper.setText("Welcome to FINRA");
		helper.setSubject("Hi");

		mailSender.send(message);

	}

}
