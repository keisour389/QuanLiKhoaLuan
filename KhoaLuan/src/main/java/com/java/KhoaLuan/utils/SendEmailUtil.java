package com.java.KhoaLuan.utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.java.KhoaLuan.config.Constant;

public class SendEmailUtil {
	public static void sendEmail(String subject, String content, String to) {
	    // Get system properties
	    Properties properties = System.getProperties();

	    // Setup mail server
	    properties.put(Constant.SMTP_AUTH_KEY, Constant.SMTP_AUTH_VALUE);
	    properties.put(Constant.SMTP_STARTTLS_ENABLE_KEY, Constant.SMTP_STARTTLS_ENABLE_VALUE);
	    properties.put(Constant.SMTP_HOST_KEY, Constant.SMTP_HOST_VALUE);
	    properties.put(Constant.SMTP_PORT_KEY, Constant.SMTP_PORT_VALUE);
	    
	    String account = Constant.ACCOUNT;
	    String password = Constant.PASSWORD;

	    // Get the default Session object.
	    Session session = Session.getInstance(properties, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(account, password);
	    	}
		});

	    try {
	       // Create a default MimeMessage object.
	       MimeMessage message = new MimeMessage(session);

	       // Set From: header field of the header.
	       message.setFrom(new InternetAddress(account));

	       // Set To: header field of the header.
	       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	       // Set Subject: header field
	       message.setSubject(subject, "UTF-8");

	       // Now set the actual message
	       message.setContent(content, "text/plain; charset=UTF-8");

	       // Send message
	       Transport.send(message);
	       System.out.println("Sent message successfully....");
	    } catch (MessagingException mex) {
	       mex.printStackTrace();
	    }
	}
}
